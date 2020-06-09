package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game game = new Game("playstation");
        Prompter prompter = new Prompter(game);

        while (game.getRemainingTries() > 0 && !game.isWon()) {
            prompter.displayProgress();
            prompter.promptForGuess();
        }

        prompter.displayOutcome();
    }
}
