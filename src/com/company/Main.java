package com.company;

import com.company.WordBanks.Consoles;
import com.company.WordBanks.Sports;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Consoles consoles = new Consoles();
        Sports sports = new Sports();
        String chosenWord = null;

        Scanner scanner = new Scanner(System.in);
        boolean isAcceptable = false;
        do {
        System.out.println("Chose 1 for consoles or 2 for sports");
        String choice = scanner.nextLine();

            if (choice.equals("1")) {
                chosenWord = consoles.getWord();
                isAcceptable = true;
            } else if (choice.equals("2")) {
                chosenWord = sports.getWord();
                isAcceptable = true;
            } else {
                System.out.println("That option doesn't exist. Pick another one.");
            }
        }while (!isAcceptable);

        Game game = new Game(chosenWord);
        Prompter prompter = new Prompter(game);

        while (game.getRemainingTries() > 0 && !game.isWon()) {
            prompter.displayProgress();
            prompter.promptForGuess();
        }

        prompter.displayOutcome();
    }
}
