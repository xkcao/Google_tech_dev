package com.xiaokang;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxSpanTest {
    public MaxSpanTest() {
    }

    @Test
    public void maxSpanTest() {
        int[] nums1 = {1, 2, 1, 1, 3};
        int[] nums2 = {1, 4, 2, 1, 4, 1, 4};
        int[] nums3 = {1, 4, 2, 1, 4, 4, 4};

        assertEquals(4, MaxSpan.maxSpan(nums1));
        assertEquals(6, MaxSpan.maxSpan(nums2));
        assertEquals(6, MaxSpan.maxSpan(nums3));
    }
}