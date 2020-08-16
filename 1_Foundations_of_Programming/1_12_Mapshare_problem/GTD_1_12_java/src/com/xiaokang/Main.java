package com.xiaokang;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<String,String> map = new HashMap<>();
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");

        map.keySet().stream().forEach(System.out::println);
        mapShare(map);
        map.keySet().stream().forEach(System.out::println);

    }

    static public Map<String, String> mapShare(Map<String, String> map) {
        if(map.get("a")!=null){
            map.put("b",map.get("a"));
        }

        map.remove("c");

        return map;
    }
}
