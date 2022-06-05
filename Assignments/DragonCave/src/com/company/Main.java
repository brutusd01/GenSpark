package com.company;

import java.util.Scanner;

class Dialogue{
    static String line1 = "%n" +
            "You are in a land full of dragons.%nIn front of you, you see two caves. " +
            "%nIn one cave, the dragon is friendly and will share his treasure with you." +
            "%nThe other dragon is greedy and hungry and will eat you on sight." +
            "%nWhich cave will you go into? (1 or 2)";

    static String fail = "%n" +
            "You approach the cave.." +
            "%nIt is dark and spooky.. Like.. Very dark. You can't really see." +
            "%nA large dragon jumps out in front of you! He opens his jaw and.." +
            "%nYou got swallowed in one bite.";

    static String win = "%n" +
            "You approach the cave.." +
            "%nYou find a big dragon on a pile of gold." +
            "%nThe dragon gives you a chest full of gold. Good job!";
}

public class Main {
    static String input = "";
    static String dialogue = "";

    public static void main(String[] args) {
	// write your code here
        System.out.println(String.format(Dialogue.line1));
        Scanner console = new Scanner(System.in);
        dialogue = getChoice(console, dialogue);
        System.out.println(String.format(dialogue)); //Prints the result.
        console.next();

    }

    public static String getChoice(Scanner console, String dialogue) {
        boolean end = false;
        int choice;
        while(!end)
        {
            input = console.nextLine();

            try {
               choice = Integer.parseInt(input);
               System.out.println("\033[1m" + input+"\033[0m");

                switch (choice) {
                    case 1:
                        dialogue = Dialogue.fail;
                        end = true;
                        break;
                    case 2:
                        dialogue = Dialogue.win;
                        end = true;
                        break;
                    default:
                        System.out.println("Enter 1 or 2.");
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception Caught: Not a whole number. Type a whole number.");
            }
        }
        return dialogue;
    }

}
