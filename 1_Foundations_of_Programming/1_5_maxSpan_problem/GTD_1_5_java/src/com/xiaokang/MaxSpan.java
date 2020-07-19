package com.xiaokang;

import java.util.HashMap;
import java.util.Map;

public class MaxSpan {
    public static int maxSpan(int[] nums){
        Map<Integer, Integer> firstIndex = new HashMap<Integer, Integer>();
        Map<Integer, Integer> span = new HashMap<Integer, Integer>();
        int maxSpan = 0;

        for(int i=0;i<nums.length;i++){
            if (firstIndex.get(nums[i]) != null) {
                span.put(nums[i],i-firstIndex.get(nums[i])+1);
            }
            else{
                firstIndex.put(nums[i],i);
                span.put(nums[i],1);
            }

            if(span.get(nums[i]) > maxSpan){
                maxSpan = span.get(nums[i]);
            }
        }

        return maxSpan;
    }
}
