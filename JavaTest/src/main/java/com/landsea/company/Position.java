package com.landsea.company;

/**
 *
 * 公司职位
 * Created by SDL on 2015/8/24.
 */
public class Position {

    private String id;
    private String name;
    private int grade;

    public Position(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }


    public Position() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
