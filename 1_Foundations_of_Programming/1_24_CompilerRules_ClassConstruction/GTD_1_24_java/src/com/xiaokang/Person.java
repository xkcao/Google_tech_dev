package com.xiaokang;

public class Person extends Object{
    private String name;

    public Person(String n){
        super();
        this.name = n;
    }

    public Person(){
        this("Person");
    }
}
