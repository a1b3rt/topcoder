package com.albert.srm620.div2;

import java.util.LinkedList;

/**
 * Created by Albert on 13.05.2014.
 */
public class PairGameEasy {

    public static void main(String[] args) {
       
    }

    public String able(int a, int b, int c, int d) {

        LinkedList<Integer> queue = new LinkedList<Integer>();
        int s = a * 10000 + b;
        queue.add(s);
        while (!queue.isEmpty()) {

            int ss = queue.removeFirst();
            int aa = ss / 10000;
            int bb = ss % 10000;
            if (aa == c && bb == d) {
                return "Able to generate";
            } else {
                if (aa + bb <= c && bb <= d)
                    queue.addLast((aa + bb) * 10000 + bb);
                if (aa <= c && aa + bb <= d)
                    queue.addLast(aa * 10000 + (aa + bb));
            }

        }
        return "Not able to generate";
    }

}
