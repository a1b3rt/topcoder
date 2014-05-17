package com.albert.srm619.div2;

import java.util.*;

/**
 * Created by Albert on 5/17/2014.
 */
public class ChooseTheBestOne {

    public static void main(String[] args) {
        new ChooseTheBestOne().countNumber(2414);
    }

    public int countNumber(int N) {
        List<Integer> employees = new ArrayList<Integer>();
        for (int i = 1; i <= N; i++) {
            employees.add(i);
        }
        long sayTo = 0;
        long round = 1;
        while (employees.size() > 1) {

            long turnToRemove = round * round * round - 1;
            sayTo = (sayTo + turnToRemove) % employees.size();

            employees.remove((int) sayTo);
            if (sayTo >= employees.size())
                sayTo = 0;
            round++;
        }
        return employees.get(0);
    }

}
