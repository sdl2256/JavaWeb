package com.sundl.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by SDL on 2015/5/29.
 */
public class User {
    int age;
    int name;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {
        String s = "{\"name\":123}";
        ObjectMapper mapper = new ObjectMapper();
        //unmarshalling (reading JSON)
        User a = mapper.readValue(s, User.class);
        //marshalling (reading JSON)
        //{"name":123}
        System.out.println(mapper.writeValueAsString(a));

    }
}
