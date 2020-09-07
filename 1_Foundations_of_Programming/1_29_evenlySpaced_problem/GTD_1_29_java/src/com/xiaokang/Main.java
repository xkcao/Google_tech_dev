package com.xiaokang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean evenlySpaced(int a, int b, int c) {
        List<Integer> inputList = new ArrayList<>();

        inputList.add(a);
        inputList.add(b);
        inputList.add(c);

        Collections.sort(inputList);

        for(int i=2;i<inputList.size();i++){
            if(inputList.get(i)-inputList.get(i-1)!=inputList.get(i-1)-inputList.get(i-2))
                return false;
        }

        return true;
    }
}
