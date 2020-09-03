package com.xiaokang;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public Map<String, String> pairs(String[] strings) {
        Map<String,String> result = new HashMap<>();

        for(String key:strings){
            if (key.length()>0){
                result.put(key.substring(0,1),key.substring(key.length()-1,key.length()));
            }
        }

        return  result;
    }
}
