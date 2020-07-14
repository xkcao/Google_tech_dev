package com.xiaokang;

public class Utility {
    public static String stringSplosion(String str) {

        if(str.length()==0) {
            return "";
        }
        else {
            return stringSplosion(str.substring(0,str.length()-1))+str;
        }
    }
}
