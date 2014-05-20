package com.albert.srm613.div2;

import java.util.Arrays;

/**
 * Created by Albert on 5/20/2014.
 */
public class TaroFriends {

    public int getNumber(int[] coordinates, int X) {
        Arrays.sort(coordinates);
        int result = coordinates[coordinates.length - 1] - coordinates[0];

        for (int i = 1; i < coordinates.length; i++) {
            int[] cloned1 = coordinates.clone();
            int[] cloned2 = coordinates.clone();
            int j = 0;
            for (; j < i; j++) {
                cloned1[j] -= X;
                cloned2[j] += X;
            }
            for (int k = j; k < coordinates.length; k++) {
                cloned1[k] += X;
                cloned2[k] -= X;
            }
            Arrays.sort(cloned1);
            Arrays.sort(cloned2);
            result = Math.min(result, Math.min(cloned1[cloned1.length - 1] - cloned1[0], cloned2[cloned2.length - 1] - cloned2[0]));
        }
        return result;
    }
}
