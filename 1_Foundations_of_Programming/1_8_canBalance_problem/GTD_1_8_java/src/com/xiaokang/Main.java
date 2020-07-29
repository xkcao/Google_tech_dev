package com.xiaokang;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class Main {

    public static void main(String[] args) {
        canBalanceTest();
    }

    public static boolean canBalance(int[] nums) {
        boolean result=false;

        Map<Integer, Integer> frontSum = new HashMap<>();
        Map<Integer, Integer> endSum = new HashMap<>();

        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            frontSum.put(i,sum);
        }

        sum=0;
        for(int i=nums.length-1;i>=0;i--){
            sum += nums[i];
            endSum.put(i,sum);
        }

        for(int i=0;i<nums.length-1;i++) {
            if (frontSum.get(i).equals(endSum.get(i + 1))) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static void canBalanceTest(){
        int[] nums1 = {1, 1, 1, 2, 1};
        int[] nums2 = {2, 1, 1, 2, 1};
        int[] nums3 = {10,10};

        assertTrue(canBalance(nums1));
        assertFalse(canBalance(nums2));
        assertTrue(canBalance(nums3));
    }

}
