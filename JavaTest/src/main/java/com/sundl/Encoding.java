package com.sundl;

/**
 * Created by SDL on 2015/7/13.
 */
public class Encoding {
    public static String key = "100110100010100010001001";

    public static String enCrypt(String str) {
        if (str == null) return null;
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            int k = new Integer(key.substring(i, i + 1));
            char c = str.charAt(i);
            char dc = (char) (c + k);
            ret.append(dc);
        }
        return ret.toString();
    }

    public static String deCrypt(String str) {
        if (str == null) return null;
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int k = new Integer(key.substring(i, i + 1));
            if (c < 32 || c > 123) k = 0;
            char dc = (char) (c - k);
            ret.append(dc);
        }
        return ret.toString();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("uid: " + enCrypt("qdshjd"));
        System.out.println("pwd: " + enCrypt("82636161"));
      System.out.println("pwd: " + enCrypt("308"));

        System.out.println("uid: " + deCrypt("maneteb"));
        System.out.println("pwd: " + deCrypt("223566"));

        System.out.println("uid: " + deCrypt("308"));
        System.out.println("pwd: " + deCrypt("223566"));

    }
}
