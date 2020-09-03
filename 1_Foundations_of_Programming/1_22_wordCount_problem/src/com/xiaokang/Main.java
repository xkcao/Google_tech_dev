package com.xiaokang;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public Map<String, Integer> wordCount(String[] strings) {
        Map<String,Integer> result = new HashMap<>();

        for(String word:strings){
            if(result.get(word)!=null){
                result.put(word,result.get(word)+1);
            }
            else {
                result.put(word,1);
            }
        }

        return result;
    }

}
