package com.xiaokang;

import org.junit.Test;

import static com.xiaokang.Main.rainWaterVolume;
import static org.junit.Assert.assertEquals;

public class MainTest {
    public MainTest() {
    }

    @Test
    public void rainWaterVolumeTest() {
        int[] heightBar1 = {1,3,2,4,1,3,1,4,5,2,2,1,4,2,2};
        int expectedResult1 = 15;
        assertEquals( expectedResult1, rainWaterVolume(heightBar1));

        int[] heightBar2 = {1,1,1};
        int expectedResult2 = 0;
        assertEquals( expectedResult2, rainWaterVolume(heightBar2));

        int[] heightBar3 = {2,1,2};
        int expectedResult3 = 1;
        assertEquals( expectedResult3, rainWaterVolume(heightBar3));

        int[] heightBar4 = {1,2,3,4,5,4,3,2,1};
        int expectedResult4 = 0;
        assertEquals( expectedResult4, rainWaterVolume(heightBar4));

        int[] heightBar5 = {4,3,2,1,2,3,4};
        int expectedResult5 = 9;
        assertEquals( expectedResult5, rainWaterVolume(heightBar5));
    }
}