package com.app.hunterkill.calculatorui;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.app.hunterkill.calculatorui.MainActivity.STATE.FIRST_OP;
import static com.app.hunterkill.calculatorui.MainActivity.STATE.RESET_SECOND_OP;
import static com.app.hunterkill.calculatorui.MainActivity.STATE.SECOND_OP;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public enum STATE {
        FIRST_OP, RESET_SECOND_OP, SECOND_OP
    }

    STATE state = FIRST_OP;
    int flagFromEqual = 0;
    String[] listOperator = {"ADD", "SUB", "MUL", "DIV"};
    String operator = "";

    BasicCalculator basicCalculator = new BasicCalculator();
    double result;

    TextView txtResult;
    int[] idCalButton = {
            R.id.btnAC,
            R.id.btnDel,
            R.id.btnEqual
    };

    int[] idOperator = {
            R.id.btnMod,
            R.id.btnAdd,
            R.id.btnSub,
            R.id.btnMul,
            R.id.btnDiv
    };

    int idBtnDot = R.id.btnDot;

    int[] idBtnNum = {
            R.id.btnNum0,
            R.id.btnNum1,
            R.id.btnNum2,
            R.id.btnNum3,
            R.id.btnNum4,
            R.id.btnNum5,
            R.id.btnNum6,
            R.id.btnNum7,
            R.id.btnNum8,
            R.id.btnNum9
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.Result);


        for (int i = 0; i < idCalButton.length; i++) {
            setupOnClick(idCalButton[i]);
        }

        for (int i = 0; i < idOperator.length; i++) {
            setupOnClick(idOperator[i]);
        }

        for (int i = 0; i < idBtnNum.length; i++) {
            setupOnClick(idBtnNum[i]);
        }
        setupOnClick(idBtnDot);
    }

    private void setupOnClick(int id) {
        Button b = (Button) findViewById(id);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (state) {
            case FIRST_OP:
                if (isNumber(v.getId())) {
                    addNumFirst_OP(v);
                } else if (isDot(v.getId())) {
                    addDot(v);
                } else if (isOperator(v.getId())) {
                    setFirstOP();
                    // store Operator wait to the next input
                    setOperator(v.getId());
                    state = RESET_SECOND_OP;
                } else {
                    actSpecialBtn(v);
                }
                break;

            case RESET_SECOND_OP:
                if (isNumber(v.getId())) {
                    String displayNumber = ((Button) v).getText().toString();
                    txtResult.setText(displayNumber);
                    state = SECOND_OP;
                } else if (isDot(v.getId())) {
                    txtResult.setText("");
                    addDot(v);
                    state = SECOND_OP;
                } else {
                    actSpecialBtn(v);
                }
                break;

            case SECOND_OP: //start to calculate and print out the result
                if (isNumber(v.getId())) {
                    addSECOND_OP(v);
                } else if (isOperator(v.getId())) {
                    setSecondOP();
                    // start Operator
                    startOperator();

                    //display to Screen
                    displayResult();

                    // set the next operator
                    setOperator(v.getId());
                    // set the first operator for the next use
                    setFirstOP();

                    state = RESET_SECOND_OP;
                } else if (isDot(v.getId())) {
                    addDot(v);
                } else {
                    actSpecialBtn(v);
                }
                break;
        }
    }

    private void addSECOND_OP(View v) {
        String displayNumber = ((Button) v).getText().toString();
        if (txtResult.getText().toString().equals("0") == true) {
            txtResult.setText(displayNumber);
        } else {
            txtResult.setText(txtResult.getText() + displayNumber);
        }
    }

    private void addNumFirst_OP(View v) {
        String displayNumber = ((Button) v).getText().toString();

        if (txtResult.getText().toString().equals("0") == true) {
            txtResult.setText(displayNumber);
        } else if (flagFromEqual == 1) {
            flagFromEqual = 0;
            txtResult.setText(displayNumber);
        } else {
            txtResult.setText(txtResult.getText() + displayNumber);
        }
    }

    private void displayResult() {
        result = basicCalculator.getResult();
        txtResult.setText(result + "");
    }

    private void actSpecialBtn(View v) {
        switch (v.getId()) {
            case R.id.btnAC:
                // reset mode
                resetScreen();
                state = FIRST_OP;
                break;
            case R.id.btnDel:
                // delete one digit if user choose operator, the they press Del nothing happen.
                if (flagFromEqual == 0) // delete can not operate when get output from equal
                    deleteCharOnScreen();
                break;
            case R.id.btnEqual:
                // nothing in state 1
                if (state == RESET_SECOND_OP) {
                    state = SECOND_OP;
                } else if (state == SECOND_OP) {
                    setSecondOP();
                    startOperator();
                    displayResult();
                    state = FIRST_OP;
                    flagFromEqual = 1;
                }
                break;
        }
    }

    private void addDot(View v) {
        String displayDot = ((Button) v).getText().toString();
        if (!isContainsDot()) {
            if (txtResult.getText().toString().equals("0") == true || txtResult.getText().toString().equals("") == true) {
                txtResult.setText("0" + displayDot);
            } else {
                txtResult.setText(txtResult.getText() + displayDot);
            }
        }
    }

    private boolean isContainsDot() {
        String str = txtResult.getText().toString();

        if (str.contains(".")) {
            return true;
        }
        return false;
    }

    private boolean isDot(int id) {
        if (id == idBtnDot) {
            return true;
        }

        return false;
    }

    private void deleteCharOnScreen() {
        String str = txtResult.getText().toString();
        if (str.length() <= 1) {
            txtResult.setText("0");

        } else {
            String strNew = str.substring(0, str.length() - 1);
            txtResult.setText(strNew);
        }
    }

    private void resetScreen() {
        operator = "";
        txtResult.setText("0");
        flagFromEqual = 0;
    }

    private void startOperator() {
        switch (operator) {
            case "MOD":  // check special condition
                basicCalculator.operateMod();
//                if (basicCalculator.getB() != 0) {
//                    basicCalculator.operateMod();
//                } else {
//                    System.out.println("Error second value can not equal 0");
//                }
                break;
            case "ADD":
                basicCalculator.operateAdd();
                break;
            case "SUB":
                basicCalculator.operateSub();
                break;
            case "MUL":
                basicCalculator.operateMul();
                break;
            case "DIV": // check special condition
                basicCalculator.operateDiv();
//                if (basicCalculator.getB() != 0) {
//                    basicCalculator.operateDiv();
//                } else {
//                    System.out.println("Error second value can not equal 0");
//                }

                break;
            default:
                break;
        }

    }

    private void setOperator(int id) {
        switch (id) {
            case R.id.btnMod:
                operator = "MOD";
                break;
            case R.id.btnAdd:
                operator = "ADD";
                break;
            case R.id.btnSub:
                operator = "SUB";
                break;
            case R.id.btnMul:
                operator = "MUL";
                break;
            case R.id.btnDiv:
                operator = "DIV";
                break;
            default:
                break;

        }
    }

    // need to limit range
    private void setSecondOP() {
        basicCalculator.setB(txtResult.getText().toString());
    }

    // need to limit range
    private void setFirstOP() {
        basicCalculator.setA(txtResult.getText().toString());
    }

    private boolean isOperator(int id) {
        for (int i = 0; i < idOperator.length; i++) {
            if (id == idOperator[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumber(int id) {
        for (int i = 0; i < idBtnNum.length; i++) {
            if (id == idBtnNum[i]) {
                return true;
            }
        }
        return false;
    }

}


