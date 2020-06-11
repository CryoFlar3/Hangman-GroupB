package com.company.WordBanks;

import java.util.Random;

public class Consoles {
    private String[] wordList = {
            "playstation",
            "xbox",
            "gamecube",
            "switch"
    };

    public String getWord() {
        Random random = new Random();
        return wordList[random.nextInt(wordList.length)].toLowerCase();
    }
}
