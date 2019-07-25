package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtA, txtB, txtOp;
    TextView txtSum;
    Button btnSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // create the title bar or bla bla
        setContentView(R.layout.activity_main); //

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtOp = findViewById(R.id.txtOp);
        txtSum= findViewById(R.id.txtSum);
        btnSum = findViewById(R.id.btnSum);

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                try{
//                    int intA = Integer.parseInt(txtA.getText().toString());
//                    int intB = Integer.parseInt(txtB.getText().toString());
//
//                    final int intSum = intA + intB; // set only the first time
//
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            txtSum.setText(intSum + "");
//                        }
//                    });
//                }
//                catch (Exception e) {
//
//                }

                int intA = Integer.parseInt(txtA.getText().toString());
                int intB = Integer.parseInt(txtB.getText().toString());

                final int intSum = intA + intB; // set only the first time

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtSum.setText(intSum + "");
                    }
                });

            }
        });

    }
}
