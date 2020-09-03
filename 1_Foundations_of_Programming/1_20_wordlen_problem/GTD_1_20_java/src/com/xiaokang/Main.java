package com.xiaokang;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public Map<String, Integer> wordLen(String[] strings) {
        Map<String,Integer> result = new HashMap<>();

        for(String entry:strings){
            result.put(entry,entry.length());
        }

        return result;
    }

}
