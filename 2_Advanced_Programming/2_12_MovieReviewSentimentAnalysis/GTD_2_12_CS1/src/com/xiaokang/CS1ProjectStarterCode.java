package com.xiaokang;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
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
		computeAverageScore("good");
		computeAverageScore("fantastic");
		computeAverageScore("extraordinary");
		computeAverageScore("bad");
		computeAverageScore("worst");
		computeAverageScore("disgusting");
	}

	static double computeAverageScore(String word) throws  FileNotFoundException
	{
		File reviewFile = new File("data/movieReviews.txt");
		Scanner reviewScanner = new Scanner(reviewFile);

		int reviewScore;
		int totalScore=0;
		int numberAppearance=0;
		double averageScore=0d;
		String reviewText;

		while(reviewScanner.hasNext())
		{
			reviewScore = reviewScanner.nextInt();
			reviewText = reviewScanner.nextLine();

			if(reviewText.toLowerCase().contains(word.toLowerCase()))
			{
				//System.out.println("Score: "+reviewScore);
				//System.out.println("Text: "+reviewText);

				totalScore += reviewScore;
				numberAppearance += 1;
			}
		}

		if (numberAppearance>0){
			averageScore = (double) totalScore/numberAppearance;
			System.out.println("- " + word + " appears " + numberAppearance + " times.");
			System.out.println("\t The average score is: " + decimalCustomFormat("##.##",averageScore));
		}else {
			System.out.println("This word does not appear.");
		}

		return averageScore;
	}

	static public String decimalCustomFormat(String pattern, double value ) {
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		return myFormatter.format(value);
		//System.out.println(value + "  " + pattern + "  " + output);
	}
}
