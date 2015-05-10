package com.sundl.spring.jdbc;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Sun on 2015/5/8.
 */

public class User {

    private Integer id;
    private java.lang.String name;
    private Date birthday;
    private String gender;
    private String info;
    private Byte[] file;
    private java.lang.String imagepath;


    public java.lang.String getImagepath() {
        return imagepath;
    }

    public void setImagepath(java.lang.String imagepath) {
        this.imagepath = imagepath;
    }

    public Byte[] getFile() {
        return file;
    }

    public void setFile(Byte[] file) {
        this.file = file;
    }


    public java.lang.String getInfo() {
        return info;
    }

    public void setInfo(java.lang.String info) {
        this.info = info;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(java.lang.String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    @Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", info='" + info + '\'' +
                ", file=" + Arrays.toString(file) +
                ", imagepath='" + imagepath + '\'' +
                '}';
    }
}
