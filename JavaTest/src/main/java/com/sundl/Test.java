package com.sundl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by SDL on 2015/7/13.
 */
public class Test {
    public static void main(String[] args) {
        /*
        System.out.println("打算");
        String string = "陆唯一";
        String eStr = null;
        try {
            eStr = URLEncoder.encode(string, "utf-8");
            System.out.println(eStr);
            System.out.println(URLDecoder.decode(eStr, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        */
        new Test().test("abc");

    }

    public void test(String str) {
        switch (str) {
            case "abc":
                System.out.println("abc");
                break;
            case "def":
                System.out.println("def");
                break;
            default:
                System.out.println("default");
        }
    }
}

