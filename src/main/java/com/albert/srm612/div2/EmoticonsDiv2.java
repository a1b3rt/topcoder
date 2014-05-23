package com.albert.srm612.div2;



/**
 * Created by Albert on 5/24/2014.
 */
public class EmoticonsDiv2 {

    public static void main(String[] args) {

    }

    public int printSmiles(int smiles) {

        int[] dp = new int[smiles + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i <= smiles; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 2;
            } else {
                int largest = greatestDivisor(i);
                dp[i] = dp[largest] + 1 + i / largest - 1;
            }
        }
        return dp[smiles] - 1;
    }

    public int greatestDivisor(int a) {
        for (int i = a / 2; i > 1; i--) {
            if (a % i == 0) {
                return i;
            }
        }
        return 1;
    }

}
