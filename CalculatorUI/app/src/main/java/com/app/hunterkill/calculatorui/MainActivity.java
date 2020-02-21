package com.app.hunterkill.calculatorui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView txtResult;
    int[] idUniButton = {
            R.id.btnAC,
            R.id.btnDel,
            R.id.btnMod,
            R.id.btnAdd,
            R.id.btnSub,
            R.id.btnMul,
            R.id.btnDiv,
            R.id.btnEqual,
            R.id.btnDot
    };
//    Button btnAC, btnDel, btnMod, btnAdd, btnSub, btnMul, btnDiv, btnEqual, btnDot;

    Button[] btnNum;
//    Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9, btnDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.Result);

        for (int i = 0; i < idUniButton.length; i++) {
            Button b = (Button) findViewById(idUniButton[i]);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // do something
                    if (v.getId() == R.id.btnAC) {
                        txtResult.setText("0");
                    }
                }
            });
        }

        btnNum = new Button[10];
        for (int i = 0; i < btnNum.length; i++) {
            String buttonId = "btnNum" + i;
            int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
            btnNum[i] = findViewById(resId);
            final int finalI = i;
            btnNum[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // do something

                    if (finalI == 1) {
                        txtResult.setText(finalI + "");
                    }
                }
            });
        }
    }

}
