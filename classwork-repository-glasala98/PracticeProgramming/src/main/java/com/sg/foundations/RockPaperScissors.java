package com.sg.foundations;

import java.util.Scanner;

public class RockPaperScissors {
    private static final String USER_WINS = "You wins!";
    private static final String COMPUTER_WINS = "Computer wins!";
    private static final String TIE = "Tie";
    private static final String[] CHOICES = { "rock", "paper", "scissors" };

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        char c = 'x';

        while (c == 'x' || c == 'y') {
            int numRounds= 0;
            int currentRound = 0;
            int ties=0, userWins=0, userLosses=0;
            System.out.print("How many rounds you want to play? Pick a number between 1 and 10!");
            numRounds = Integer.parseInt(s.nextLine());

            if(numRounds < 1 || numRounds > 10) {
                System.out.println("That's not a valid number of rounds!");
                System.exit(1);
            }

            while(currentRound < numRounds) {
                int userChoice = getUserChoice(s);
                int computerChoice = (int) (Math.random() * 3);

                System.out.println("Round " + (currentRound + 1) + ":");
                System.out.println("User picked " + CHOICES[userChoice]);
                System.out.println("Computer picked " + CHOICES[computerChoice]);

                String winner = winner(userChoice, computerChoice);
                System.out.println(winner);

                if(winner.equals(USER_WINS)) {
                    userWins++;
                }
                if(winner.equals(COMPUTER_WINS)) {
                    userLosses++;
                }
                if(winner.equals(TIE)) {
                    ties++;
                }
                System.out.println();
                currentRound++;
            }

            System.out.println("Match(es) concluded");
            System.out.println("User won " + userWins);
            System.out.println("Computer won " + userLosses);
            System.out.println("Ties " + ties);

            if(userWins > userLosses) {
                System.out.println("Player wins!");
            }
            else if(userLosses > userWins) {
                System.out.println("Computer wins!");
            }
            else {
                System.out.println("It's a Tie!");
            }
            System.out.print("Do you want to play again(y/n): ");
            c = s.nextLine().charAt(0);
        }
        System.out.println("Thanks for playing!");
        s.close();
    }

    private static String winner(int user, int computer) {
        switch (user) {
            case 0:
                switch (computer) {
                    case 0:
                        return TIE;
                    case 1:
                        return COMPUTER_WINS;
                    case 2:
                        return USER_WINS;
                }
            case 1:
                switch (computer) {
                    case 0:
                        return USER_WINS;
                    case 1:
                        return TIE;
                    case 2:
                        return COMPUTER_WINS;
                }
            case 2:
                switch (computer) {
                    case 0:
                        return COMPUTER_WINS;
                    case 1:
                        return USER_WINS;
                    case 2:
                        return TIE;
                }
        }
        return TIE;
    }

    public static int getUserChoice(Scanner s) {
        int userChoice = 0;
        System.out.print("Enter your choice:\n 1: Rock \n 2: Paper \n 3: Scissors \n");
        boolean valid = false;

        while (!valid) {
            userChoice = Integer.parseInt(s.nextLine());
            if (userChoice >= 1 && userChoice <= 3) {
                valid = true;
            } else {
                System.out.println("invalid Response. Try again: ");
            }
        }
        // translate to array index 0 to 2
        userChoice--;
        return userChoice;
    }


}

