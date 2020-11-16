package com.xiaokang;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;

/*
 * @author: Xiaokang CAO
 */
public class CS1ProjectStarterCode
{
	public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {
		scoreWordList();
	}

	static void scoreWordList() throws FileNotFoundException, ExecutionException, InterruptedException {
		Scanner keyboard = new Scanner(System.in);
		String filePath, mostPositiveWord="", mostNegativeWord="";
		double mostPositiveScore=0, mostNegativeScore=99d;
		double averageScore=0d;
		int numWords = 0;
		Hashtable<String, Future<Double>> wordScoreMap = new Hashtable<>();

		System.out.print("Enter the name of the file with words you want to find average score for: ");
		filePath = keyboard.nextLine();

		File wordListFile = new File(filePath);
		Scanner wordListScanner = new Scanner(wordListFile);

		ExecutorService executorService = Executors.newFixedThreadPool(8);
		while(wordListScanner.hasNext()){
			String word = wordListScanner.nextLine();

			Future<Double> future = executorService.submit(() -> computeAverageScore(word));

			wordScoreMap.put(word,future);
		}

		executorService.shutdown();
		executorService.awaitTermination(100, TimeUnit.SECONDS);

		for(Map.Entry<String, Future<Double>> entry : wordScoreMap.entrySet()){
			double score = entry.getValue().get();
			if (score>mostPositiveScore) {
				mostPositiveWord = entry.getKey();
				mostPositiveScore = score;
			}
			if(score<mostNegativeScore){
				mostNegativeWord = entry.getKey();
				mostNegativeScore = score;
			}

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

			System.out.println("The most positive word, with a score of " + decimalCustomFormat("##.##",mostPositiveScore) + " is " + mostPositiveWord);
			System.out.println("The most negative word, with a score of " + decimalCustomFormat("##.##",mostNegativeScore) + " is " + mostNegativeWord);
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
