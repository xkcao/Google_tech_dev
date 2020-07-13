package com.xiaokang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    public MainTest() {

    }

    @Test
    public void longestWordTest1() {
        System.out.println("Now running longestWordTest1..");;

        String targetString = "abppplee";

        List<String> dictionary = new ArrayList<String>();
        dictionary.add("able");
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("bale");
        dictionary.add("kangaroo");

        String result = Main.longestWord(targetString,dictionary);

        assertEquals("apple", result);
    }

    @Test
    public void longestWordTest2() {
        System.out.println("Now running longestWordTest2..");;

        String targetString = "abppplee";

        List<String> dictionary = new ArrayList<String>();
        dictionary.add("able");
        dictionary.add("ale");
        dictionary.add("bale");
        dictionary.add("kangaroo");

        String result = Main.longestWord(targetString,dictionary);

        assertEquals("able",result);
    }

    @Test
    public void longestWordTest3() {
        System.out.println("Now running longestWordTest3..");;

        String targetString = "abppplee";

        List<String> dictionary = new ArrayList<String>();
        dictionary.add("bale");
        dictionary.add("kangaroo");

        String result = Main.longestWord(targetString,dictionary);

        assertEquals("", result);
    }
}