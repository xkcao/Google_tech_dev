package com.xiaokang;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MainTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    static int rainWaterVolume(int[] heightBar){
        int maxIndex = indexOfLargestValue(heightBar);
        int leftIndex=0;
        int leftRunningMax=heightBar[leftIndex];
        int rightIndex = heightBar.length-1;
        int rightRunningMax=heightBar[rightIndex];
        int leftVolume=0;
        int rightVolume=0;

        while(leftIndex<maxIndex){
            if(heightBar[leftIndex]>leftRunningMax){
                leftRunningMax = heightBar[leftIndex];
            }else{
                leftVolume += leftRunningMax - heightBar[leftIndex];
            }

            leftIndex++;
        }

        while (rightIndex>maxIndex){
            if(heightBar[rightIndex]>rightRunningMax){
                rightRunningMax = heightBar[rightIndex];
            }else {
                rightVolume += rightRunningMax - heightBar[rightIndex];
            }

            rightIndex--;
        }

        return (leftVolume + rightVolume);
    }

    /**
     * find the index of largest value in an array of integer.
     * In case there are more than 1 largest values, return the smallest index.
     * @param input input array
     * @return the index of largest value
     */
    static int indexOfLargestValue(int[] input){
        int index = 0;
        for(int i=0;i<=input.length-1;i++){
            if(input[i]>input[index]) index = i;
        }

        return index;
    }

}
