package com.xiaokang;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public String[] encoder(String[] raw, String[] code_words) {
        Map<String, String> rawCodeMap = new HashMap<>();
        String[] result = new String[raw.length];

        int i=0,j=0;
        while (i<raw.length){
            if(rawCodeMap.get(raw[i])!=null){
                result[i]= rawCodeMap.get(raw[i]);
                i++;
            }
            else{
                rawCodeMap.put(raw[i],code_words[j]);
                result[i]=code_words[j];
                i++;
                j++;
            }
        }

        return result;
    }
}
