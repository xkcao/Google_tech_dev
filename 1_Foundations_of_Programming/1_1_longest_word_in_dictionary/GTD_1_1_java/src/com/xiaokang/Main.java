package com.xiaokang;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    /**
     * @param targetString
     * @param dictionary
     * @return
     */
    public static String longestWord(String targetString, List<String> dictionary)
    {
        String matchedWord = "";

        Collections.sort(dictionary, Comparator.comparingInt(String::length));
        Collections.reverse(dictionary);

        for(String word:dictionary)
        {
            if (isSubsequence(targetString,word) )
            {
                matchedWord = word;
                break;
            }
        }

        return matchedWord;
    }

    /**
     * @param targetString
     * @param testString
     * @return
     */
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
