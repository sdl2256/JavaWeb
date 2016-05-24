package com.sundl;

import com.sundl.model.Student;

import java.util.*;

/**
 * Created by SDL on 2015/12/21.
 */
public class TestList {

    public static void main(String[] args) {


        List<Student> ls = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Student s = new Student();
            s.setId();
            s.setAge(s.getId()/10);
            s.setName("stu-"+i);
            s.setBirthday(new Date());
            ls.add(s);
        }
        Collections.sort(ls, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        for (Student ss:ls){
            System.out.println(ss);
        }
    }
}
