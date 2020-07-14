package com.xiaokang;


public class Main {

    public static void main(String[] args) {

        int[] ages = {17, 21, 18, 19};

        boolean[] student = new boolean[4];
        student[0] = true;
        student[1] = true;
        student[2] = false;
        student[3] = true;

        for(int i : ages) {
            System.out.println(i);
        }
    }
}
