package com.app.hunterkill.moviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.exoplayer2.ui.PlayerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnAction, btnDoc, btnEpic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAction = findViewById(R.id.btnActionMovies);
        btnDoc = findViewById(R.id.btnDocumentaryMovies);
        btnEpic = findViewById(R.id.btnEpicMovies);

        btnAction.setOnClickListener(this);
        btnDoc.setOnClickListener(this);
        btnEpic.setOnClickListener(this);

    }

    ImageButton preButton;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnActionMovies:
                invisibleBackground(preButton);
                visibleBackground(btnAction);
                preButton = btnAction;
//                Toast toast = Toast.makeText(MainActivity.this, "test", Toast.LENGTH_LONG);
//                toast.show();

                break;
            case R.id.btnDocumentaryMovies:
                invisibleBackground(preButton);
                visibleBackground(btnDoc);
                preButton = btnDoc;


                break;
            case R.id.btnEpicMovies:
                invisibleBackground(preButton);
                visibleBackground(btnEpic);
                preButton = btnEpic;



                break;
            default:
                break;


        }


    }

    private void visibleBackground(ImageButton btnIcon) {
        if (btnIcon != null) {
            btnIcon.setBackgroundResource(R.drawable.button_focus_state);
        }
    }

    private void invisibleBackground(ImageButton btnIcon) {
        if (btnIcon != null) {
            btnIcon.setBackgroundResource(R.drawable.button_normal_state);
        }
    }
}
