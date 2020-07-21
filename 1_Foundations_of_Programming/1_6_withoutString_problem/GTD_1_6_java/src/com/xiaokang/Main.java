package com.xiaokang;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class Main {

    public static void main(String[] args) {
	// write your code here
        withoutStringTest();
    }

    public static String withoutString(String base, String remove){
        String result="";

        int i=0;
        while (i<base.length()){
            if(i+remove.length()>base.length()){
                result += base.substring(i,base.length());
                break;
            }
            else if (base.substring(i,i+remove.length()).equalsIgnoreCase(remove)){
                i = i+remove.length();
            }
            else
            {
                result += String.valueOf(base.charAt(i));
                ++i;
            }
        }

        return result;
    }

    @Test
    public static void withoutStringTest(){
        assertEquals("He there", withoutString("Hello there","llo"));
        assertEquals("Hllo thr", withoutString("Hello there","e"));
        assertEquals("Hello there", withoutString("Hello there", "x"));
    }
}
