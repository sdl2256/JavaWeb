package com.sundl.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SDL on 2015/5/29.
 */
public class Dom4jDemo {
    public static void main(String[] args) {
        String pathname = "d://books.xml";
        int i = createXMLFile(pathname);
        System.out.println(i);
    }

    private static int createXMLFile(String pathname) {

        int returnValue = 0;
        try {
            Document document = DocumentHelper.createDocument();
            document.addComment("一个简单的xml文档的事例");
            //document.addProcessingInstruction("target", "instruction");
            Element root = document.addElement("books");
            for (int i = 0; i < 5; i++) {
                Element bookElement = root.addElement("book");
                Element nameElement = bookElement.addElement("name");
                nameElement.addText("计算机技术概论" + i);
                Element authorElement = bookElement.addElement("author");
                authorElement.addText("王敏" + i);
                Element element = bookElement.addElement("date");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = dateFormat.format(new Date());
                element.addText(date);
            }
            //美化输出格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(new FileWriter(new File(pathname)), format);
            writer.write(document);
            writer.close();
            returnValue = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnValue;
    }


}
