package com.xiaokang;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] candies = {1,1,2,2,3,3};

        int maximumType = Solution.distributeCandies(candies);
        System.out.println("Maximum types of candies are: "+maximumType);
    }

    static class Solution {
        public static int distributeCandies(int[] candies) {
            Set<Integer> candyType=new HashSet<>();

            for(int i=0;i<candies.length;i++){
                candyType.add(candies[i]);
            }

            return Math.min(candyType.size(),candies.length/2);
        }
    }
}
