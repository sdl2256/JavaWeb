package com.sundl.entity;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Created by SDL on 2015/5/29.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "book", propOrder = { "author", "calendar", "price", "id" })
public class Book {
    @XmlElement(required = true)
    private String author;

    @XmlElement(name = "price_1", required = true)
    private float price;

    @XmlElement
    private Date calendar;

    @XmlAttribute
    private Integer id;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCalendar() {
        return calendar;
    }

    public void setCalendar(Date calendar) {
        this.calendar = calendar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", price=" + price +
                ", calendar=" + calendar +
                ", id=" + id +
                '}';
    }
}

