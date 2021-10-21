package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class MiniZork {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house with a large red barn");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, open the mailbox, or go to the barn? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }

            } else if (action.equals("stick your hand in")) {
                System.out.println("You reach around a bit and feel a stone lever!");
                System.out.println("Do you pull or push it?");
                action = userInput.nextLine();
                if(action.equals("pull it")){
                    System.out.println("The Stones beneath you begin to shake!");
                    System.out.println("A door opens to your left!");
                    System.out.println("It's a tomb full of rare treasure take what you can and run!");
                }
                    else if (action.equals("push it")){
                        System.out.println("You here a loud creek!");
                        System.out.println("Ope you've lost your arm better find someone!");
                }
            }

        } else if (action.equals("go to the house")) {
            System.out.println("Do you knock on the front door or go through the open window?");
            action = userInput.nextLine();
            if (action.equals("front door")) {
                System.out.println("You knock on the front door.");
                System.out.println("It's swings open.");
                System.out.print("A creepy old lady is there with cookies do you take on y/n? ");
                action = userInput.nextLine();
                if (action.equals("y")) {
                    System.out.println("Oh wow they are amazing.");
                    System.out.println("Ope you've grown wings this is awkward.");
                } else if (action.equals("n")) {
                    System.out.println("You decline the offer she seems upset with you and reaches for her pocket.");
                    System.out.println("She pulls out a wand and cast a spell on you. You're now a frog ribbit!");
                }
            }
                else if (action.equals("open window")){
                    System.out.println("You squeeze through the open window");
                    System.out.println("There is a three headed dog sleeping at your feet!");
                    System.out.print("Do you sneak past or leave?");
                    action = userInput.nextLine();
                    if (action.equals("sneak past")) {
                        System.out.println("The dog wakes up from a creek in the floor. Unlucky...");
                        System.out.println("Well life was good...");
                    } else if (action.equals("leave")) {
                        System.out.println("You jump out the window and run as fast as you can.");
                        System.out.println("But you're alive. Possibly a wise choice.");
                    }
            }
        }
        else if (action.equals("go to the barn")) {
            System.out.println("Do you go through the barn door or peak through the window?");
            action = userInput.nextLine();
            if (action.equals("barn door")) {
                System.out.println("It creaks loudly as you open it.");
                System.out.println("A group of masked individuals rushes you and ties you up");
                System.out.print("The ask you if you wish to live y/n ");
                action = userInput.nextLine();

                if (action.equals("y")) {
                    System.out.println("They allow you to join their group!");
                    System.out.println("You've been granted magical powers and sick looking robes SCORE!.");
                } else if (action.equals("n")) {
                    System.out.println("Ah how unfortunate!");
                    System.out.println("One of them waves their hand and you are turned to dust POOF!");
                }
            }
                else if (action.equals("peak through the window")){
                    System.out.println("You see some sort of cermony going on with masked individuals in robes");
                    System.out.println("Do you sneak in or leave");
                    action = userInput.nextLine();
                    if (action.equals("sneak in")) {
                        System.out.println("You clumsily fall through the door. Unlucky...");
                        System.out.println("Everyone turns to look at you I don't think you are going anywhere");
                    } else if (action.equals("leave")) {
                        System.out.println("You turn run as fast as you can.");
                        System.out.println("But you're alive. Possibly a wise choice.");
                    }
            }

        }
    }
}