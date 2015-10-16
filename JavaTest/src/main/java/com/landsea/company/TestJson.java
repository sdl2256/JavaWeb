package com.landsea.company;

import com.alibaba.fastjson.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDL on 2015/9/16.
 */
public class TestJson {
    public static void main(String[] args) {
        Position da = new Position("da", 2);
        Position db = new Position("db", 3);
        List ls = new ArrayList<>();

        ls.add(da);
        ls.add(db);
        String s = JSON.toJSONString(da);
        String s1 = JSONArray.toJSONString(ls);
        System.out.println(s);
        System.out.println(s1);
    }
}
