package com.sundl.dom4j;

import java.util.ArrayList;

/**
 * Created by SDL on 2015/5/29.
 */
public class Books {
    //根节点books对应Books类，book节点对应Book类，有多个book节点，这里需转换到集合中
    private ArrayList<Book> books;

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
