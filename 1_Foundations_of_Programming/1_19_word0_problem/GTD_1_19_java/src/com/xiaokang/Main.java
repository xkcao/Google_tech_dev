package com.xiaokang;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public Map<String, Integer> word0(String[] strings) {
        Map<String,Integer> result = new HashMap<>();

        for(String word:strings){
            result.put(word,0);
        }
        return  result;
    }

}
