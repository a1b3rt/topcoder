package com.albert.srm520.div2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Albert on 5/20/2014.
 */
public class SRMCodingPhase {

    public static void main(String[] args) {
        int[] points = {300, 600, 900};
        int[] skills = {30, 65, 90};
        int luck = 25;

        new SRMCodingPhase().countScore(points, skills, luck);
    }

    public int countScore(int[] points, int[] skills, int luck) {
        int result = 0;
        int n = 1 << points.length;

        for (int q = 0; q < n; q++) {

            int[] clonedPoints = points.clone();
            int[] clonedSkills = skills.clone();

            for (int w = 0; w < skills.length; w++) {
                if ((q & 1 << w) == 0) {
                    clonedPoints[w] = 0;
                    clonedSkills[w] = 0;
                }
            }
            int b= 4;
            for (int i = 0; i <= luck; i++) {
                for (int j = luck - i; j >= 0; j--) {
                    int k = luck - i - j;
                    int first = clonedSkills[0] - i > 0 ? clonedSkills[0] - i : clonedSkills[0] == 0 ? 0 : 1;
                    int second = clonedSkills[1] - j > 0 ? clonedSkills[1] - j : clonedSkills[1] == 0 ? 0 : 1;
                    int third = clonedSkills[2] - k > 0 ? clonedSkills[2] - k : clonedSkills[2] == 0 ? 0 : 1;
                    if (first + second + third <= 75) {
                        int current = clonedPoints[0] - 2 * first + clonedPoints[1] - 4 * second + clonedPoints[2] - 8 * third;
                        result = Math.max(result, current);
                    }
                }
            }
        }
        return result;
    }

}
