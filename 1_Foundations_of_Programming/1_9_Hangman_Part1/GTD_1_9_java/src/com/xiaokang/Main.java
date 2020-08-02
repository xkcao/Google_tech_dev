package com.xiaokang;

public class Main {


    public static void main(String[] args) {

        Hangman hangman = new Hangman();

        hangman.initialize();

        while(!hangman.gameEnd){
            hangman.showStatus();
            hangman.userGuess();
            hangman.showAnswer();
        }

        hangman.showEndResult();
    }
}
