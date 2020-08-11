package com.xiaokang;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Student s = new Student();
        Person p = new Person();
        Person q = new Person();
        Faculty f = new Faculty();
        Object o = new Faculty();

        String n = s.getName();
        p = s;
        int m = ((Student)p).getId();
        //f = q;
        o = s;
    }
}
