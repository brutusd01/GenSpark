package com.company;

import java.util.Scanner;

public class Main {
    static int input;
    public static void main(String[] args) {
	// write your code here
        String line1 = "%n" +
                "You are in a land full of dragons.%nIn front of you, you see two caves. " +
                "%nIn one cave, the dragon is friendly and will share his treasure with you." +
                "%nThe other dragon is greedy and hungry and will eat you on sight." +
                "%nWhich cave will you go into? (1 or 2)";

        String fail = "%n" +
                "You approach the cave.." +
                "%nIt is dark and spooky.. Like.. Very dark. You can't really see." +
                "%nA large dragon jumps out in front of you! He opens his jaw and.." +
                "%nYou got swallowed in one bite.";

        String win = "%n" +
                "You approach the cave.." +
                "%nYou find a big dragon on a pile of gold." +
                "%nThe dragon gives you a chest full of gold. Good job!";



        System.out.println(String.format(line1));
        Scanner console = new Scanner(System.in);
        String dialogue = "";

           getInput: while(console.hasNextInt())
           {
            input = console.nextInt();
            switch (input) {
                   case 1:
                       dialogue = fail;
                       break getInput;
                   case 2:
                       dialogue = win;
                       break getInput;
                   default:
                       //dialogue = invalid;
                       System.out.println("Invalid.");
               }
               System.out.println("\033[1m" + input+"\033[0m");
           }

        System.out.println(String.format(dialogue));

    }

}
