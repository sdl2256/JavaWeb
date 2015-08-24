package com.sundl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by SDL on 2015/7/1.
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Integer it = map.put("id", new Integer(1));
        Integer it1 = map.put("id", new Integer(2));
        Integer name = map.put("name", new Integer(333));
        // 在放入第一个 id 元素的时候，因为之前没有 id，所以返回值为 null
        // 在第二次放入 id 的时候，因为之前已经有了一个 id 了，所以在放入新元素之前需要将原来的元素给返回给调用者
        System.out.println(it);
        System.out.println(it1);
        System.out.println(name);
        Iterator iterator = map.keySet().iterator();

        System.out.println(map);
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()).toString());
        }
        if (map.containsKey("name"))
            map.put("name",444);

        System.out.println(map);
    }
}
