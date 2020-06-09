package com.company;

import java.util.Scanner;

public class Prompter {
    private Game game;

    public Prompter(Game game){
        this.game = game;
    }

    public boolean promptForGuess(){
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptable = false;

        do {
            System.out.print("Enter a letter: ");
            String guessInput = scanner.nextLine();
            try {
                isHit = game.applyGuess(guessInput.charAt(0));
                isAcceptable = true;
            }catch (IllegalArgumentException iae){
                System.out.printf("%s. Please try again. %n", iae.getMessage());
            }
        }while (!isAcceptable);
        return isHit;
    }

    public void displayProgress(){
        System.out.println(game.getProgress());
    }

    public void displayOutcome(){
        if (game.isWon()){
            System.out.printf("Congrats! you won with $s tries remaining! %n", game.getRemainingTries());
        } else {
            System.out.printf("Bummer. The correct answer was %s, %n", game.getAnswer());
        }
    }
}
