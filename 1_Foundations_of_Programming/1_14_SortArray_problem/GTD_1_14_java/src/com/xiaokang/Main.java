package com.xiaokang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    int[] sort(int[] a) {
        Set<Integer> inputSet = new HashSet<>();
        int[] b;

        for (int i:a){
            if (!inputSet.contains(i)){
                inputSet.add(i);
            }
        }

        b = new int[inputSet.size()];

        int j=0;
        for (Integer element : inputSet){
            b[j++] = element;
        }

        return  b;
    }
}
