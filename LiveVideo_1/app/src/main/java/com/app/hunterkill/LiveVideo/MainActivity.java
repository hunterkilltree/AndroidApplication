package com.app.hunterkill.LiveVideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    private ImageButton btnVoice, btnSetting;
    private TextView txtVoiceStatus, txtSettingStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVoice = findViewById(R.id.btnVoice);
        btnSetting = findViewById(R.id.btnSetting);

        txtSettingStatus = findViewById(R.id.txtSetting);
        txtVoiceStatus = findViewById(R.id.txtVoiceStatus);

        btnVoice.setOnFocusChangeListener(this);
        btnSetting.setOnFocusChangeListener(this);

//        btnSetting.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus) txtSettingStatus.setVisibility(View.VISIBLE);
//                else txtSettingStatus.setVisibility(View.INVISIBLE);
//            }
//        });
//
//        btnVoice.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus) txtVoiceStatus.setVisibility(View.VISIBLE);
//                else txtVoiceStatus.setVisibility(View.INVISIBLE);
//            }
//        });
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()){
            case R.id.btnVoice:
                visibleText(txtVoiceStatus, hasFocus);
                break;
            case R.id.btnSetting:
                visibleText(txtSettingStatus, hasFocus);
                break;

        }
    }

    public void visibleText(TextView txt, boolean hasFocus) {
        if (hasFocus) {
           txt.setVisibility(View.VISIBLE);
        } else {
            txt.setVisibility(View.INVISIBLE);
        }
    }
}
