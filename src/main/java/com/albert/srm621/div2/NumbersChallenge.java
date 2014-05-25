package com.albert.srm621.div2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Albert on 5/25/2014.
 */
public class NumbersChallenge {

    public static void main(String[] args) {
        new NumbersChallenge().MinNumber(new int[] {2, 1, 2, 7});
    }

    public int MinNumber(int[] S) {

        int n = S.length;
        int subsets = 1 << n;
        List<Integer> numbers = new ArrayList<>(subsets);

        for (int i = 0; i < subsets; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += S[j];
                }
            }
            numbers.add(sum);
        }
        int min = Integer.MAX_VALUE;
        numbers = new ArrayList<>(new HashSet<>(numbers));
        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (i != numbers.get(i)) {
                return i;
            }
        }
        return numbers.size();
    }
}
