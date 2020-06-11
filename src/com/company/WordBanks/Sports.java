package com.company.WordBanks;

import java.util.Random;

public class Sports {
    private String[] wordList = {
            "football",
            "basketball",
            "futball",
            "hockey"
    };

    public String getWord() {
        Random random = new Random();
        return wordList[random.nextInt(wordList.length)].toLowerCase();
    }
}
