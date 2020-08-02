package com.xiaokang;

import java.util.HashSet;
import java.util.Scanner;

public class Hangman {
    String word;
    int remainingGuess;
    String currentWord;
    boolean gameEnd ;
    boolean userWon ;
    boolean initialized;
    final int MAX_GUESS_NUMBER = 8;
    char userLetter;
    HashSet<Character> userCorrectLetters;

    public Hangman() {
        this.remainingGuess = MAX_GUESS_NUMBER;
        this.word = "";
        this.currentWord = "";
        this.gameEnd = false;
        this.userWon = false;
        this.initialized = false;
        userCorrectLetters = new HashSet<Character>();
    }

    public void initialize(){
        System.out.println("Welcome to Hangman!");

        HangmanLexicon hangmanLexicon = new HangmanLexicon();

        /**
         * generate a random integer range from 0 to [hangmanLexicon.getWordCount()-1]
         */
        int wordIndex = (int)(Math.random() * (hangmanLexicon.getWordCount() - 0 ) + 0);
        word = hangmanLexicon.getWord(wordIndex);

        System.out.println("word: "+word);

        for(int i =0;i<word.length();i++){
            currentWord += "-";
        }

        initialized = true;
    }

    public void showStatus(){
        if(!initialized) initialize();

        System.out.println("The word now looks like this: " + currentWord);
        System.out.println("You have "+remainingGuess+" guesses left.");
    }

    public void userGuess(){
        if(!initialized) initialize();
        Scanner s = new Scanner(System.in);

        boolean guessOK = false;
        String userEntry="";

        while(!guessOK){
            System.out.print("Your guess: ");
            userEntry = s.next();
            userLetter = userEntry.charAt(0);

            if (userEntry.length()==1 && Character.isLetter(userLetter) && !userCorrectLetters.contains(Character.toUpperCase(userLetter))){
                guessOK = true;
            }
            else if(userCorrectLetters.contains(Character.toUpperCase(userLetter))){
                System.out.println("This letter is correct, but you already guessed it before. Please try again.");
            }
            else {
                System.out.println("Your guess is illegal. Only single letter is accepted. Please try again.");
            }
        }

            remainingGuess--;
    }

    public void showAnswer(){
        if(!initialized) initialize();
        boolean correctGuess = false;
        String previousWord = currentWord;
        currentWord = "";

        for (int i=0;i<word.length();i++){
            if(previousWord.charAt(i)!='-'){
                currentWord += previousWord.charAt(i);
            }
            else if(Character.toUpperCase(userLetter) == Character.toUpperCase(word.charAt(i))){
                currentWord += Character.toUpperCase(userLetter);

                if(!userCorrectLetters.contains(Character.toUpperCase(userLetter))){
                    userCorrectLetters.add(Character.toUpperCase(userLetter));
                    correctGuess = true;
                }
            }
            else{
                currentWord += "-";
            }
        }

        if(correctGuess){
            System.out.println("That guess is correct");
        }
        else{
            System.out.println("There are no "+Character.toUpperCase(userLetter)+"'s in the word");
        }

        if(remainingGuess<=0 || isUserWon()) gameEnd = true;
    }

    public void showEndResult(){
        if(!initialized) initialize();
        
        userWon = isUserWon();

        if(userWon){
            System.out.println("you guessed the word: "+currentWord);
            System.out.println("You win");
        }
        else{
            System.out.println("You're completely hung.");
            System.out.println("The word was: "+word);
            System.out.println("You lose.");
        }
    }

    public boolean isUserWon(){
        boolean won = true;

        for(int i=0;i<word.length();i++){
            if(currentWord.charAt(i)=='-'){
                won = false;
                break;
            }
        }

        return won;
    }
}
