package com.xiaokang;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String targetString = "abppplee";

        List<String> dictionary = new ArrayList<String>();
        dictionary.add("able");
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("bale");
        dictionary.add("kangaroo");

        String matchedWord =  longestWord(targetString,dictionary);
        System.out.println("The matched word is: " + matchedWord);
    }

    /**
     * @param targetString
     * @param dictionary
     * @return
     */
    public static String longestWord(String targetString, List<String> dictionary)
    {
        String matchedWord = "";

        int length=0;
        for(String word:dictionary)
        {
            if (isSubsequence(targetString,word) && word.length()>length)
            {
                length = word.length();
                matchedWord = word;
            }
        }

        return matchedWord;
    }

    public static boolean isSubsequence(String targetString, String testString)
    {
        boolean isSubsequence = false;

        int i=1;
        int j=1;
        for(i=1;i<=testString.length();i++)
        {
            if(j>targetString.length()) break;

            while(j<=targetString.length() && testString.charAt(i-1)!=targetString.charAt(j-1))
            {
                j++;
            }
        }

        if (j<=targetString.length()) isSubsequence=true;

        return isSubsequence;
    }
}
