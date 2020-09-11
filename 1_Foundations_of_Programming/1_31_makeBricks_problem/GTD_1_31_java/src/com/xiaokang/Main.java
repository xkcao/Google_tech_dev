package com.xiaokang;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean makeBricks(int small, int big, int goal) {
        int numSmall = small;
        int numBig = big;
        int sum = small + big*5;

        while(sum>goal && (numSmall>0 || numBig>0)){
            if((numBig>0 && sum-5>=goal) || numSmall==0){
                numBig--;
            }else if(numSmall>0){
                numSmall--;
            }

            sum = numSmall + numBig*5;
        }

        return (sum==goal);
    }

}
