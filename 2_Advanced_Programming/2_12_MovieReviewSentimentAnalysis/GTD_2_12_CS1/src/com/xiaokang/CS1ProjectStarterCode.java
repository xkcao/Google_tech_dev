package com.xiaokang;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * @author: Xiaokang CAO
 */
public class CS1ProjectStarterCode
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		String filePath;
		double score;
		double averageScore=0d;
		int numWords = 0;

		System.out.print("Enter the name of the file with words you want to find average score for: ");
		filePath = keyboard.nextLine();

		File wordListFile = new File(filePath);
		Scanner wordListScanner = new Scanner(wordListFile);

		while(wordListScanner.hasNext()){
			String word = wordListScanner.nextLine();
			score = computeAverageScore(word);

			averageScore += score;
			numWords += 1;
		}

		if(numWords>0){
			averageScore = averageScore/numWords;
			System.out.println("The average score of the words in " + filePath + " is " +  decimalCustomFormat("##.##", averageScore));

			if(averageScore>=2.01){
				System.out.println("The overall sentiment of " + filePath + " is positive");
			}else{
				System.out.println("The overall sentiment of " + filePath + " is negative");
			}
		}else{
			System.out.println("No words found in "+filePath);
		}
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
			//System.out.println("- " + word + " appears " + numberAppearance + " times.");
			//System.out.println("\t The average score is: " + decimalCustomFormat("##.##",averageScore));
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
