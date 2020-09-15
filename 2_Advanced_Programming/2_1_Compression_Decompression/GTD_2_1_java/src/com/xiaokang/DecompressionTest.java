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
        String input = "2[3[a]b";
        String expectedOutput = "aaabaaab";

        assertEquals(expectedOutput,Decompression.decompressString(input));
    }
}