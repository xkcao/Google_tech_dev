package com.xiaokang;

import java.util.ArrayList;
import java.util.List;

public class Decompression {
    public static String decompressString(String input){
        List<IntegerStringPair> subStringMaps = divideString(input);
        StringBuffer output = new StringBuffer();

        for(IntegerStringPair numberStringPair: subStringMaps){
            for(int i=0;i<numberStringPair.getNumber();i++)
            {
                if (!hasBrackets(numberStringPair.getString())){
                    output.append(numberStringPair.getString());
                }
                else
                {
                    output.append(decompressString(numberStringPair.getString()));
                }
            }
        }

        return output.toString();
    }

    static List<IntegerStringPair> divideString(String input){
        List<IntegerStringPair> output = new ArrayList<>();
        IntegerStringPair numberStringPair;

        int i=0;
        while(i<input.length()){
            if(Character.isLetter(input.charAt(i))) {
                //charAt(i) is a single letter
                numberStringPair = new IntegerStringPair();
                numberStringPair.setNumber(1);
                numberStringPair.setString(input.substring(i,i+1));

                output.add(numberStringPair);
                i++;
            }
            else if(Character.isDigit(input.charAt(i))){
                //charAt(i) is a digit, now need to get the whole number
                int j=i+1;
                while(Character.isDigit(input.charAt(j))) j++;
                int number = Integer.parseInt(input.substring(i,j));

                //charAt(j) is the open bracket [, need to get the corresponding end bracket
                int m=j+1;
                int openBracketNumber = 1;
                int endBracketNumber = 0;

                while(m<input.length() && openBracketNumber-endBracketNumber>0){
                    if(input.charAt(m) == '[') {
                        openBracketNumber+=1;
                    }
                    else if(input.charAt(m)==']') {
                        endBracketNumber+=1;
                    }

                    m++;
                }
                //charAt(m-1) is the end bracket ]

                numberStringPair = new IntegerStringPair();
                numberStringPair.setNumber(number);
                numberStringPair.setString(input.substring(j+1,m-1));

                output.add(numberStringPair);

                i = m;
            }
        }

        return output;
    }

    static boolean hasBrackets(String input){
        return (input.indexOf('[')!=-1);
    }

    static class IntegerStringPair{
        int number;
        String string;

        void setNumber(int number){
            this.number = number;
        }

        int getNumber(){return number;}

        void setString(String input){
            string = new String(input);
        }

        String getString(){return string;}
    }
}
