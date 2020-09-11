package com.xiaokang;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean makeBricks(int small, int big, int goal) {
        //fail #1 -- not enough bricks
        if (goal > small + big*5) return false;

        // fail #2 -- not enough small bricks
        if (goal % 5 > small) return false;

        return true;
    }

}
