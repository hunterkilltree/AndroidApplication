package com.app.hunterkill.uibasics;

import android.text.method.NumberKeyListener;
import android.widget.EditText;

/**
 * Created by hunterkill on 20/02/2020.
 */

public class BasicCaculator {
    private double a;
    private double b;
    private double res;

    public BasicCaculator() {
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

    public double operateAdd() {
        return this.a + this.b;
    }

    public double operateSub() {
        return this.a - this.b;
    }

    public double operateDiv() {
        res =  this.a / this.b;
        return res;
    }

    public double operateMul() {
        return this.a * this.b;
    }
}
