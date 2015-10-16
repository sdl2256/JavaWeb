package com.sundl;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by SDL on 2015/7/28.
 */
public class TestProperties {
    private Properties prop = new Properties();//属性集合对象

    public TestProperties() {
    }

    public boolean write(String key, String value) {
        ///保存属性到b.properties文件
        FileOutputStream oFile = null;//true表示追加打开
        try {
            oFile = new FileOutputStream("b.properties");
            prop.setProperty("phone", "10086");
            prop.store(oFile, "The New properties file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Object o = prop.setProperty(key, value);

        return false;
    }

    public String read(String key) {
        try {
            FileInputStream fis = new FileInputStream("prop.properties");//属性文件流
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String property = prop.getProperty(key);
        return property;
    }



    public static void main(String[] args) {
        String s = System.getProperty("user.dir");
        System.out.println(s);
        Properties prop = new Properties();
        try {
            //读取属性文件a.properties
            InputStream in = new BufferedInputStream(new FileInputStream("prop.properties"));
            prop.load(in);     ///加载属性列表
            Iterator<String> it = prop.stringPropertyNames().iterator();
            while (it.hasNext()) {
                String key = it.next();
                System.out.println(key + ":" + prop.getProperty(key));
            }
            in.close();

            ///保存属性到b.properties文件
            FileOutputStream oFile = new FileOutputStream("prop.properties");//true表示追加打开
            prop.setProperty("land", "10086");
            prop.store(oFile, "The New properties file");
            oFile.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
