package com.xiaokang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
public class DecompressionTest {

    @Test
    public void decompressStringTest() {
        String input = "3[abc]4[ab]c";
        String expectedOutput = "abcabcabcababababc";

        assertEquals(expectedOutput,Decompression.decompressString(input));
    }

    @Test
    public void decompressStringTest2() {
        String input = "10[a]";
        String expectedOutput = "aaaaaaaaaa";

        assertEquals(expectedOutput,Decompression.decompressString(input));
    }

    @Test
    public void decompressStringTest3() {
        String input = "2[3[a]b]";
        String expectedOutput = "aaabaaab";

        assertEquals(expectedOutput,Decompression.decompressString(input));
    }

    @Test
    public void decompressStringTest4() {
        String input = "a[]b";
        String expectedOutput = "ab";

        assertEquals(expectedOutput,Decompression.decompressString(input));
    }

    @Test
    public void decompressStringTest5() {
        String input = "0[abc]";
        String expectedOutput = "";

        assertEquals(expectedOutput,Decompression.decompressString(input));
    }
}