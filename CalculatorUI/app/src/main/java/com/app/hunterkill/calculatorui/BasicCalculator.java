package com.app.hunterkill.calculatorui;

import android.text.method.NumberKeyListener;
import android.widget.EditText;

/**
 * Created by hunterkill on 20/02/2020.
 */

public class BasicCalculator {
    private double a;
    private double b;
    private double res;

    public BasicCalculator() {
        this.a = 0;
        this.b = 0;
    }

    public double getA() {
        return a;
    }

    public void setA(String a) {
        this.a = Double.parseDouble(a);
    }

    public double getB() {
        return b;
    }

    public void setB(String b) {
        this.b = Double.parseDouble(b);
    }

    public void operateAdd() {
        res = this.a + this.b;
    }

    public void operateSub() {
        res = this.a - this.b;
    }

    public void operateDiv() {
        if (this.b == 0 ) {
            throw new IllegalArgumentException("Can not divide 0");
        }
        res = this.a / this.b;
    }

    public void operateMul() {
        res = this.a * this.b;
    }

    public void operateMod() {
        if (this.b == 0 ) {
            throw new IllegalArgumentException("Can not mod 0");
        }
        res = this.a % this.b;
    }

    public  double getResult() {
        return res;
    }
}