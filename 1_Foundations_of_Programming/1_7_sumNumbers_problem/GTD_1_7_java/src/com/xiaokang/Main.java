package com.xiaokang;

import static org.junit.Assert.assertEquals;

public class Main {

    public static void main(String[] args) {
	// write your code here
        sumNumbersTest();
    }

    public static int sumNumbers(String str) {

        int result=0;
        int numStart=-1;
        int numEnd=-1;

        for(int i=0;i<str.length();i++){
            if(numStart==-1 && Character.isDigit(str.charAt(i))) {
                numStart = i;
                numEnd = i;
            }else if(numStart>=0 && Character.isDigit(str.charAt(i))){
                numEnd = i;
            }else if (!Character.isDigit(str.charAt(i)) && numStart>=0 && numEnd>=0){
                result +=  Integer.parseInt(str.substring(numStart,numEnd+1));
                numStart = -1;
                numEnd = -1;
            }
        }

        if(numStart>=0 && numEnd>=0){
            result +=  Integer.parseInt(str.substring(numStart,numEnd+1));
        }

        return result;
    }

    public static void sumNumbersTest(){
        assertEquals(123, sumNumbers("abc123xyz"));
        assertEquals(44, sumNumbers("aa11b33"));
        assertEquals(18, sumNumbers("7 11"));
    }
}
