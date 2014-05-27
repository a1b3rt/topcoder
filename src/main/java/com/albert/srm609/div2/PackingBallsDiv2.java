package com.albert.srm609.div2;

/**
 * Created by Albert on 5/27/2014.
 */
public class PackingBallsDiv2 {

    public int minPacks(int R, int G, int B) {
        int result = 0;

        result += R / 3;
        R = R % 3;

        result += G / 3;
        G = G % 3;

        result += B / 3;
        B = B % 3;

        if (R + G + B > 3) result += 2;
        else if (R == 1 && G == 1 && B == 1) result += 1;
        else if (R + G + B == 3) result += 2;
        else if(R + G + B != 0) result += 1;
        return result;

    }

}
