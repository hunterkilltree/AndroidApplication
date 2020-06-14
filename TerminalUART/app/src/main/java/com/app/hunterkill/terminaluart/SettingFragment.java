package com.app.hunterkill.terminaluart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hunterkill on 20/05/2020.
 */

public class SettingFragment extends ListFragment implements AdapterView.OnItemClickListener {
    String[] listItemsBaudRate;
    String[] listItemsParity;
    String[] listItemsDataBits;
    String[] listItemsStopBits;

    private int checkItemBaudRate = 0;
    private int checkItemParity = 0;
    private int checkItemDataBits = 0;
    private int checkItemStopBits = 0;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.setting_list, android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);

        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(parent);
        System.out.println(view);
        System.out.println(position);
        System.out.println(id);

        // declare
        AlertDialog.Builder builder;
        AlertDialog mDialog;
        switch (position) {
            case 0: // Serial
//                getFragmentManager().beginTransaction().replace(R.id.fragment_contain, new TerminalFragment(), "terminal").commit();
                listItemsBaudRate = new String[] {"9600", "115200", "3200"};
                builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choose");

                // check position
                if (SerialValue.baudrate == 9600) {
                    checkItemBaudRate = 0;

                }
                else if (SerialValue.baudrate == 115200) {
                    checkItemBaudRate = 1;
                }
                else if (SerialValue.baudrate == 3200) {
                    checkItemBaudRate = 2;
                }


                builder.setSingleChoiceItems(listItemsBaudRate, checkItemBaudRate, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        checkItemBaudRate = i;
                        // set change value
                        SerialValue.baudrate = Integer.parseInt(listItemsBaudRate[i]);

                        dialog.dismiss();

                    }
                });

                // Create button Cancel
                // Position is the button order (left to right) was POSITIVE - NEUTRAL - NEGATIVE.
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                // display
                mDialog = builder.create();
                mDialog.show();
                break;
            case 1:
                listItemsParity = new String[] {"None", "Odd","Even"};
                builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choose");
                builder.setSingleChoiceItems(listItemsParity, SerialValue.parity, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        checkItemParity = i;
                        SerialValue.parity = i; // wrong need to review
                        // set change value
                        dialog.dismiss();

                    }
                });

                // Create button Cancel
                // Position is the button order (left to right) was POSITIVE - NEUTRAL - NEGATIVE.
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                // display
                mDialog = builder.create();
                mDialog.show();
                break;
            case 2:
                listItemsDataBits = new String[] {"8", "7","6", "5"};
                builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choose");

                if (SerialValue.dataBits == 8) {
                    checkItemDataBits = 0;

                } else if (SerialValue.dataBits == 7) {
                    checkItemDataBits = 1;

                } else if (SerialValue.dataBits == 6) {
                    checkItemDataBits = 2;

                } else if (SerialValue.dataBits == 5) {
                    checkItemDataBits = 4;

                }


                builder.setSingleChoiceItems(listItemsDataBits, checkItemDataBits, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        checkItemDataBits = i;
                        SerialValue.dataBits = Integer.parseInt(listItemsDataBits[i]);
                        // set change value
                        dialog.dismiss();

                    }
                });

                // Create button Cancel
                // Position is the button order (left to right) was POSITIVE - NEUTRAL - NEGATIVE.
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                // display
                mDialog = builder.create();
                mDialog.show();
                break;
            case 3:
                listItemsStopBits = new String[] {"1", "1.5","2"};
                builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choose");

                if (SerialValue.stopBits == 1) {
                    checkItemStopBits = 0 ;
                } else if (SerialValue.stopBits == 1.5) {
                    checkItemDataBits = 1;
                }
                else if (SerialValue.stopBits == 2) {
                    checkItemDataBits = 2;
                }
                builder.setSingleChoiceItems(listItemsStopBits, checkItemDataBits, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        checkItemStopBits = i;
                        // set change value
                        SerialValue.stopBits = Integer.parseInt(listItemsStopBits[i]);
                        dialog.dismiss();
                    }
                });

                // Create button Cancel
                // Position is the button order (left to right) was POSITIVE - NEUTRAL - NEGATIVE.
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                // display
                mDialog = builder.create();
                mDialog.show();
                break;
            default:
                break;
        }

    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
