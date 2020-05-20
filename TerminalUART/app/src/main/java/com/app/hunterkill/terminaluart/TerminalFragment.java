package com.app.hunterkill.terminaluart;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.driver.UsbSerialProber;
import com.hoho.android.usbserial.util.SerialInputOutputManager;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * Created by hunterkill on 20/05/2020.
 */

public class TerminalFragment extends Fragment implements SerialInputOutputManager.Listener {
    private static final String ACTION_USB_PERMISSION = "com.android.recipes.USB_PERMISSION";
    private enum Connected { False, Pending, True }
    private int deviceId, portNum, baudRate;
    private String newline = "\r\n";
    private TextView txtReceiveText;

    private SerialInputOutputManager usbIoManager;
    private Handler mainLooper;

    private UsbSerialPort usbSerialPort;
//    private Serial socket;
//    private SerialListener  service;
    private Thread readThread;
    private boolean mRunning;

    // check connection
    private Connected connected = Connected.False;

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);

        // set up thong so
//        deviceId = getArguments().getInt("device");
//        portNum = getArguments().getInt("port");
//        baudRate = getArguments().getInt("baud");

        // meo dung
        deviceId = 1212;
        portNum = 233231;
        baudRate = 1434324;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terminal, container, false);
        txtReceiveText = view.findViewById(R.id.receive_text);
        txtReceiveText.setMovementMethod(ScrollingMovementMethod.getInstance()); // allow scrolling view


        //action for sent data
        final TextView sendText = view.findViewById(R.id.send_text);
        final ImageButton  btnSend = view.findViewById(R.id.btn_send_message);





        UsbManager manager = (UsbManager) getActivity().getSystemService(Context.USB_SERVICE);
        List<UsbSerialDriver> availableDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(manager);

        if (availableDrivers.isEmpty()) {
            Log.d("UART", "UART is not available");
            connected = Connected.False;

        }else {
            Log.d("UART", "UART is available");
            connected = Connected.True;

            UsbSerialDriver driver = availableDrivers.get(0);
            UsbDeviceConnection connection = manager.openDevice(driver.getDevice());
            if (connection == null) {
                manager.requestPermission(driver.getDevice(), PendingIntent.getBroadcast(getActivity(), 0, new Intent(ACTION_USB_PERMISSION), 0));
            } else {
                // Most devices have just one port (port 0)
                usbSerialPort = driver.getPorts().get(0);

                usbIoManager = new SerialInputOutputManager(usbSerialPort, this);
                Executors.newSingleThreadExecutor().submit(usbIoManager);

                try {
                    usbSerialPort.open(connection);
                    usbSerialPort.setParameters(115200, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE);

                    btnSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sendMessage(sendText.getText().toString());

                            Toast.makeText(getActivity(), sendText.getText().toString(), Toast.LENGTH_SHORT).show();

                        }
                    });


                    SerialInputOutputManager usbIoManager = new SerialInputOutputManager(usbSerialPort, (SerialInputOutputManager.Listener) getActivity());
                    Executors.newSingleThreadExecutor().submit(usbIoManager);
                } catch (Exception e) {

                }

            }
        }

//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendMessage(sendText.getText().toString());
//
//            }
//        });

        return  view;
    }

    private void sendMessage(String str) {
        if(connected != Connected.True) {
            Toast.makeText(getActivity(), "not connected", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            SpannableStringBuilder spn = new SpannableStringBuilder(str+'\n');
            txtReceiveText.append(spn);
            byte[] data = (str + newline).getBytes();
            usbSerialPort.write("1".getBytes(), 1000);


        } catch (Exception e) {
            System.out.println("Send Error");
        }
    }

    private void receive(byte[] data) {

        txtReceiveText.append(new String(data));
        Toast.makeText(getActivity(), txtReceiveText.getText().toString(), Toast.LENGTH_SHORT).show();
    }




    @Override
    public void onNewData(final byte[] data) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                txtOut.append(Arrays.toString(data));
                receive(data);
                Toast.makeText(getActivity(), "fdsada", Toast.LENGTH_SHORT).show();

//                try {
//                    usbSerialPort.read(data, 1000);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        });


    }

    @Override
    public void onRunError(Exception e) {

    }
}