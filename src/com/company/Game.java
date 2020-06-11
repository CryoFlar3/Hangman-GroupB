package com.company;

import java.util.Random;

public class Game {
    public static final int MAX_MISSES = 7;
    private String answer;
    private String hits;
    private String misses;

    public Game(String answer) {
        this.answer = answer;
        hits = "";
        misses = "";
    }

    private char normalizeGuess(char letter){
        if (!Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        if (hits.indexOf(letter) != -1 || misses.indexOf(letter) != -1){
            throw new IllegalArgumentException("You've already guessed " + letter);
        }
        return letter;
    }

    public boolean applyGuess(char letter){
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if (isHit){
            hits += letter;
        } else{
            misses += letter;
        }
        return isHit;
    }

    public boolean applyGuess(String letters){
        if (letters.length() == 0){
            throw new IllegalArgumentException("No letter found");
        }
        if (answer.equals(letters.toLowerCase())){
            hits += letters;
            return true;
        }
        return applyGuess(letters.charAt(0));
    }

    public String getProgress(){
        String progress = "";
        for (char letter : answer.toCharArray()){
            char display = '-';
            if (hits.indexOf(letter) != -1){
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public int getRemainingTries(){
        return MAX_MISSES - misses.length();
    }

    public boolean isWon(){
        return getProgress().indexOf('-') == -1;
    }

    public String getAnswer() {
        return answer;
    }
}
