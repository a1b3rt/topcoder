package com.albert.srm616.div2;

import java.util.*;

/**
 * Created by Albert on 5/19/2014.
 */
public class ColorfulCoinsEasy {

    public static void main(String[] args) {
        new ColorfulCoinsEasy().isPossible(new int[] {1, 2, 4});
    }

    public String isPossible(int[] values) {
        int[] noMoreThan = new int[values.length - 1];
        for (int i = 1; i < values.length; i++) {
            noMoreThan[i - 1] = values[i] / values[i - 1] - 1;
        }
        Arrays.sort(noMoreThan);
        Set<Integer> used = new HashSet<>();
        for (int j : noMoreThan) {
            for (int i = 1; i <= j; i++) {
                if (!used.contains(i)) {
                    used.add(i);
                    break;
                } else if (i == j) {
                    return "Impossible";
                }
            }
        }
        return "Possible";
    }
}