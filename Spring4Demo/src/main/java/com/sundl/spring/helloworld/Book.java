package com.sundl.spring.helloworld;

/**
 * Created by Sun on 2015/5/9.
 */
public class Book {
    private String bookname;

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                '}';
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
