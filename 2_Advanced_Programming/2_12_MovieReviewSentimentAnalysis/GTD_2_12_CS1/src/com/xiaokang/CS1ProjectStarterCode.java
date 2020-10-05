package com.xiaokang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * This is code I wrote with students in class to demonstrate how to read from the movie review file.
 * It searches each review for the queried word and just prints out the score of that review along 
 * with its text to ensure that we can read the two values and use the .contains() method properly.
 */
public class CS1ProjectStarterCode 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		File reviewFile = new File("data/movieReviews.txt");
		Scanner reviewScanner = new Scanner(reviewFile);
		Scanner keyboard = new Scanner(System.in);

		int reviewScore;
		String reviewText;
		String word;

		System.out.println("Enter a word.");
		word = keyboard.nextLine();

		while(reviewScanner.hasNext())
		{
			reviewScore = reviewScanner.nextInt();
			reviewText = reviewScanner.nextLine();

			if(reviewText.contains(word))
			{
				System.out.println("Score: "+reviewScore);
				System.out.println("Text: "+reviewText);
			}
		}
	}

}
