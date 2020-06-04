package com.company;

public class Game {
    private String answer;
    private String hits;
    private String misses;

    public Game(String answer) {
        this.answer = answer;
        hits = "";
        misses = "";
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
}
