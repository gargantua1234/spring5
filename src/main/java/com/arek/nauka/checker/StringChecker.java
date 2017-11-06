package com.arek.nauka.checker;

/**
 * Created by Arek on 02.11.2017.
 */
class StringChecker {

    boolean isPalindrome(String word){
        if(isEmptyOrNull(word))
            return false;

        String original = getCharSequence(word);
        String reversed = reverseWord(original);
        return reversed.equals(original);
    }

    private boolean isEmptyOrNull(String word){
        return word == null || word.equals("");
    }

    private String getCharSequence(String word){
        return word
                .replaceAll("[^A-z0-9]", "")
                .toLowerCase();
    }

    private String reverseWord(String word){
        StringBuilder reversed = new StringBuilder(word);
        return reversed
                .reverse()
                .toString();
    }
}
