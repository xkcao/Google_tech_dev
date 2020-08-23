package com.xiaokang;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int interpret(int value, String[] commands, int[] args) {
        if (commands.length!=args.length) return -1;
        int result = value;

        for(int i=0;i<commands.length;i++){
            switch (commands[i]){
                case "+":
                    result += args[i];
                    break;
                case "-":
                    result -= args[i];
                    break;
                case "*":
                    result *= args[i];
                    break;
                default:
                    return -1;
            }
        }

        return result;
    }
}
