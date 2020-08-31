package com.xiaokang;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<String,Integer> myMap = new HashMap<>();
        myMap.put("clemence",9);
        myMap.put("Amy",3);

        for(String key:myMap.keySet()){
            System.out.println(key+"->"+myMap.get(key));
        }
    }
}
