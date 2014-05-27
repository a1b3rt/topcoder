package com.albert.srm608.div2;

import java.util.Arrays;

/**
 * Created by Albert on 5/27/2014.
 */
public class MysticAndCandiesEasy {

    public int minBoxes(int C, int X, int[] high) {
        Arrays.sort(high);
        for (int i = 0; i < high.length; i++) {
            int maxDiscarded = 0;
            for (int j = 0; j <= i; j++) {
                maxDiscarded += high[j];
            }
            if (C - maxDiscarded < X) {
                return high.length - i;
            }
        }
        return 0;
    }

}
