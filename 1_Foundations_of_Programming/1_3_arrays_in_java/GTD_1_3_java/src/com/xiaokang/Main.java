package com.xiaokang;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] ages = {17, 21, 18, 19};

        boolean[] student = new boolean[4];
        student[0] = true;
        student[1] = true;
        student[2] = false;
        student[3] = true;

        System.out.println(Arrays.toString(ages));
        System.out.println(Arrays.toString(student));
    }
}
