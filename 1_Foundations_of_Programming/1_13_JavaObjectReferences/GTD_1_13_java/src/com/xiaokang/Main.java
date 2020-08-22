package com.xiaokang;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Object obj = new Object();
        System.out.println(obj);

        String foo = new String("Hello");
        String bar = new String("bye");

        System.out.println(foo);
        System.out.println(bar);

        bar = foo;

        System.out.println(foo);
        System.out.println(bar);
    }
}
