package com.xiaokang;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MainTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    static int rainWaterVolume(int[] heightBar){
        int leftIndex = smallestIndexMax(heightBar,0,heightBar.length-1);
        int rightIndex = leftIndex;
        int leftVolume=0;
        int rightVolume=0;

        while(leftIndex>0){
            int secondLeftIndex = smallestIndexMax(heightBar,0,leftIndex-1);
            for(int i=secondLeftIndex+1;i<leftIndex;i++){
                leftVolume += heightBar[secondLeftIndex] - heightBar[i];
            }

            leftIndex = secondLeftIndex;
        }

        while ((rightIndex<heightBar.length-1)){
            int secondRightIndex = largestIndexMax(heightBar,rightIndex+1,heightBar.length-1);
            for (int i=rightIndex+1;i<secondRightIndex;i++){
                rightVolume += heightBar[secondRightIndex] - heightBar[i];
            }

            rightIndex = secondRightIndex;
        }

        return (leftVolume + rightVolume);
    }

    /**
     * find the smallest index with the max value in an array of integer between index start and end
     * @param input input array
     * @param start start index, 0 is the first element
     * @param end end index
     * @return
     */
    static int smallestIndexMax(int[] input, int start, int end){
        if(start<0) start = 0;
        if(end>input.length-1) end = input.length -1;

        //initialize
        int index = start;
        for(int i=start;i<=end;i++){
            if(input[i]>input[index]) index = i;
        }

        return index;
    }

    /**
     * find the largest index with the max value in an array of integer between index start and end
     * @param input input array
     * @param start start index, 0 is the first element
     * @param end end index
     * @return
     */
    static int largestIndexMax(int[] input, int start, int end){
        if(start<0) start = 0;
        if(end>input.length-1) end = input.length -1;

        //initialize
        int index = start;

        for(int i=start;i<=end;i++){
            if(input[i]>=input[index]) index = i;
        }

        return index;
    }
}
