package com.arek.nauka.checker;

/**
 * Created by Arek on 02.11.2017.
 */
class PalindromeChecker {

    boolean isPalindrome(String word) throws IllegalArgumentException{
        if(isEmptyOrNull(word))
            throw new IllegalArgumentException("You can not check the empty word");

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
