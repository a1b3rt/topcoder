package com.albert.srm618.div2;

/**
 * Created by Albert on 5/18/2014.
 */
public class LongWordsDiv2 {

    public String find(String word) {
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                return "Dislikes";
            }
        }
        for (int i = 0; i < word.length() - 3; i++) {
            for (int j = i + 1; j < word.length() - 2; j++) {
                for (int k = j + 1; k < word.length() - 1; k++) {
                    for (int l = k + 1; l < word.length(); l++) {
                        if (word.charAt(i) == word.charAt(k) && word.charAt(j) == word.charAt(l)) {
                            return "Dislikes";
                        }
                    }
                }
            }
        }
        return "Likes";
    }

}
