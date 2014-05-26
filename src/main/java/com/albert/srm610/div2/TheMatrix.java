package com.albert.srm610.div2;

/**
 * Created by Albert on 5/26/2014.
 */
public class TheMatrix {

    public static void main(String[] args) {
        String[] condition = {"0", "0", "0", "1", "1", "0", "1", "1", "1", "0", "0", "1"};
        new TheMatrix().MaxArea(condition);
    }

    public int MaxArea(String[] board) {

        int h = board.length;
        int w = board[0].length();
        int result = 1;
        for (int i = 0; i < w; i++) {
            for (int j = i; j < w; j++) {
                int strLen = j - i + 1;
                String[] valid = getValidStr(strLen);
                int start = - 1;
                int end = - 1;
                boolean first = true;
                for (int k = 0; k < h; k++) {
                    String current = board[k].substring(i, j + 1);
                    if (start == - 1 && (current.equals(valid[0]) || current.equals(valid[1]) )) {
                        start = k;
                        first = current.equals(valid[0]) ? false : true;
                        result = Math.max(result, current.length());
                    } else if (current.equals(valid[first ? 0 : 1])) {
                        end = k;
                        first = !first;
                        result = Math.max(result, current.length() * (end - start + 1));
                    } else if (start != -1) {
                        start = - 1;
                        k--;
                    }
                }
            }
        }
        return result;
    }

    public String[] getValidStr(int len) {

        char[] str1 = new char[len];
        char[] str2 = new char[len];
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                str1[i] = '0';
                str2[i] = '1';
            } else {
                str1[i] = '1';
                str2[i] = '0';
            }
        }
        return new String[] {new String(str1), new String(str2)};
    }

}
