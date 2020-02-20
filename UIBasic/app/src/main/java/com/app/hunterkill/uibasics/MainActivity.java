package com.app.hunterkill.uibasics;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BasicCaculator basicCaculator = new BasicCaculator();

    private EditText valueA, valueB;
    private TextView notificationValueA, notificationValueB;
    private TextView viewResult;
    private Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    private double result;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueA = (EditText) findViewById(R.id.valueA);
        valueB = (EditText) findViewById(R.id.valueB);

        notificationValueA = (TextView) findViewById(R.id.notificationValueA);
        notificationValueB = (TextView) findViewById(R.id.notificationValueB);

        viewResult = (TextView) findViewById(R.id.result);

        buttonAdd = (Button) findViewById(R.id.add);
        buttonAdd.setOnClickListener(this);

        buttonSub = (Button) findViewById(R.id.subtract);
        buttonSub.setOnClickListener(this);

        buttonMul = (Button) findViewById(R.id.multi);
        buttonMul.setOnClickListener(this);

        buttonDiv = (Button) findViewById(R.id.divide);
        buttonDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getInput();
        id = v.getId();

        if (id == R.id.add) {
            result = basicCaculator.operateAdd();
        } else if (id == R.id.subtract) {
            result = basicCaculator.operateSub();
        } else if (id == R.id.multi) {
            result = basicCaculator.operateMul();
        } else if (id == R.id.divide) {
            if (basicCaculator.getB() == 0) {
                viewResult.setText("Error");
                displaySetErrorB();
                return;
            }
            result = basicCaculator.operateDiv();
        }
        viewResult.setText(result + "");
    }


    private void getInput() {
        try {
            displaySetA();
        } catch (Exception e) {
            //showToastError(Gravity.TOP | Gravity.END,"Input A", 0, 90);
           displaySetErrorA();
        }

        try {
            displaySetB();
        } catch (Exception e) {
            //showToastError( Gravity.END,"Input B", 0, 0);
           displaySetErrorB();
        }
    }

    private void displaySetErrorB() {
        notificationValueB.setTextColor(Color.RED);
        notificationValueB.setText("Error value");
    }

    private void displaySetB() {
        basicCaculator.setB(valueB.getText().toString());
        notificationValueB.setText("");
    }

    private void displaySetErrorA() {
        notificationValueA.setTextColor(Color.RED);
        notificationValueA.setText("Error value");
    }

    private void displaySetA() {
        basicCaculator.setA(valueA.getText().toString());
        notificationValueA.setText("");
    }

//    private void showToastError(int gravity, String error, int xOffset, int yOffset) {
//        Toast toast = Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG);
//        toast.setGravity(gravity, xOffset, yOffset);
//        toast.show();
//    }
}
