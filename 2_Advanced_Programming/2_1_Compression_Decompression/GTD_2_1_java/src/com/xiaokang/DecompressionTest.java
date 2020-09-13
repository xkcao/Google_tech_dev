package com.xiaokang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
public class DecompressionTest {

    @Test
    public void testDecompressString() {
        String input1 = "3[abc]4[ab]c";
        String expectedOutput1 = "abcabcabcababababc";

        String input2 = "10[a]";
        String expectedOutput2 = "aaaaaaaaaa";

        String input3 = "2[3[a]b";
        String expectedOutput3 = "aaabaaab";

        assertEquals(expectedOutput1,Decompression.decompressString(input1));
        assertEquals(expectedOutput2,Decompression.decompressString(input2));
        assertEquals(expectedOutput3,Decompression.decompressString(input3));
    }
}