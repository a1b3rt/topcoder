package com.albert.srm617.div2;

/**
 * Created by Albert on 5/18/2014.
 */
public class SlimeXSlimonadeTycoon {

    public static void main(String[] args) {

        int[] morning = {10, 20, 30};
        int[] customers = {30, 20, 10};
        int stale_limit = 1;

        new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit);
    }

    public int sell(int[] morning, int[] customers, int stale_limit) {
        int result = 0;
        int n = morning.length;
        for (int i = 0; i < n; i++) {
            int sold = 0;
            for (int j = i - stale_limit + 1 >= 0 ? i - stale_limit + 1 : 0; j <= i; j++) {
                if (morning[j] <= customers[i]) {
                    customers[i] -= morning[j];
                    sold += morning[j];
                    morning[j] = 0;
                } else {
                    morning[j] -= customers[i];
                    sold += customers[i];
                    customers[i] = 0;
                }
            }
            result += sold;
        }
        return result;
    }
}
