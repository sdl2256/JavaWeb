package com.sundl.xstream;

/**
 * Created by SDL on 2015/5/29.
 */
public class PhoneNumber {
    private int code;
    private String number;

    public PhoneNumber(int i, String s) {
        this.code = i;
        this.number = s;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "code=" + code +
                ", number='" + number + '\'' +
                '}';
    }
}
