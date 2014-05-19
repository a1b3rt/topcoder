package com.albert.srm615.div2;

/**
 * Created by Albert on 5/19/2014.
 */
public class LongLongTripDiv2 {

    public String isAble(long D, int T, int B) {

        long t = T;
        long b = B;

        for (long i = 0; i <= t / 2 + 1; i++) {
            if (i * 1 + (t - i) * b == D || i * b + (t - i) * 1 == D) {
                return "Possible";
            }
        }
        return "Impossible";
    }

}
