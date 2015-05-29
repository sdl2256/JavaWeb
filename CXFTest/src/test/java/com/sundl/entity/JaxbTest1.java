package com.sundl.entity;

import com.sundl.utils.JaxbUtil;
import org.junit.Test;

import java.util.Date;

/**
 * Created by SDL on 2015/5/29.
 *
 * 最简单转换
 */
public class JaxbTest1 {

    @Test
    public void showMarshaller() {
        Book book = new Book();
        book.setId(100);
        book.setAuthor("James");
        book.setCalendar(new Date());
        book.setPrice(23.45f);   //默认是0.0

        String str = JaxbUtil.convertToXml(book);
        System.out.println(str);
    }

    @Test
    public void showUnMarshaller() {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<book id=\"100\">" +
                "    <author>James</author>" +
                "   <calendar>2013-03-29T09:25:56.004+08:00</calendar>" +
                "  <price_1>23.45</price_1>" +
                "</book>";

        Book book = JaxbUtil.converyToJavaBean(str, Book.class);
        System.out.println(book);
    }

}
