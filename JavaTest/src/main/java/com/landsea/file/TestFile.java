package com.landsea.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by SDL on 2015/9/10.
 */
public class TestFile {
    public static void main(String[] args) {
//        String filename = "F:/TileImages/0/0/00/0/0/0/0/00/0.txt";
//        File filepath = new File(filename.substring(0, filename.lastIndexOf("/")));
//        if (!filepath.exists()) {
//            filepath.mkdirs();
//        }
//        File file = new File(filename);
////        boolean mkdirs = file.mkdirs();
//        try {
//            FileOutputStream output = new FileOutputStream(file);
//            output.write(123);
//            output.flush();
//            output.close();
//        } catch (FileNotFoundException e) {
//
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 0; i < 100; i++) {
//            double pow = Math.pow(2, i);
//            int res = (int) pow;
//            System.out.println("2的" + i + "次方为：" + res);
//        }


        String uri = "http://192.168.104.246:8080/WebchartServer/getTile/0/0/1/0/1";
//        String uri = "http://192.168.104.246:8080/WebchartServer/getTile/0/0/${z}/${x}/${y}";
//        uri.lastIndexOf()
        String tmp = uri.substring(uri.indexOf("getTile/0/0"), uri.length()).replace("getTile/0/0", "");

        System.out.println(tmp);
    }
}
