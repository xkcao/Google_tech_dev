package com.xiaokang;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String message = "Hello, world!";

        message = message.concat(" Good day.");

        message = message.toUpperCase();

        message = message.replace('O','2');

        System.out.println(message);

        char[] characters = message.toCharArray();

        for(char c : characters) {
            System.out.print(c);
        }
        System.out.println();
    }
}
