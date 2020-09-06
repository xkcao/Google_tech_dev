package com.xiaokang;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int blackjack(int a, int b) {
        if(a>21 && b>21){
            return 0;
        }
        else if(a>21){
            return b;
        }
        else if(b>21){
            return a;
        }
        else if(21-a<21-b){
            return a;
        }
        else {
            return b;
        }
    }
}
