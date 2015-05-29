package com.sundl.dom4j;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by SDL on 2015/5/29.
 */
public class XStreamDemo {
    public static void main(String[] args) {
        xmlToJavaBean();
    }

    /**
     * 把xml转化为java对象
     */
    public static void xmlToJavaBean() {
        XStream stream = new XStream();
        String xml = "d://books.xml";
        try {
            stream.alias("book", Book.class);
            stream.alias("books", Books.class);
            //设置隐含转化集合

            //根节点books对应Books类，book节点对应Book类，有多个book节点，这里需转换到集合中
            stream.addImplicitCollection(Books.class, "books");
            Books books = (Books) stream.fromXML(new FileReader(new File(xml)));
            ArrayList<Book> bookList = books.getBooks();
            for (int i = 0; i < bookList.size(); i++) {
                Book book = (Book) bookList.get(i);
                System.out.println("name：" + book.getName() + "，" + "author:" + book.getAuthor() + "，" + "date:" + book.getDate());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
