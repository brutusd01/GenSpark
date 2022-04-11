import java.util.Scanner;

class Dialogue{ //Class to house the strings for dialogue.
    //Dialogue lines!
    static String intro = "Hello! Welcome to my game. First of all, what is your name?";
    static String enter = "%nInput your first name below:";
    static String enter2 = "%nInvalid input. Guess a whole number only.";
    static String noName = "%nToo shy huh? That's fine.";
    static String line1 = "%nWell.. %s I have a number in mind." +
            "%nIt is between 1 and 20." +
            "%nTell me.. Can you guess it?";
    static String high = "%nNope, lower.";
    static String low = "%nNope, higher.";
    static String win = "%nGood job, %s! It took you %s tries but you got it!";
    static String firstTry = "%nReally? First try? You must be a wizard. You win.";
    static String cont = "%nWanna go again, %s?(Y/N)";
    static String newNum = "%nAwesome! I have a new number in mind.. Try to guess it!";
    static String end = "%nThat's fine, hope you have a good one!";
    static String enter3 = "%nType Y or N.";
}

public class Main {

    public static int privateNum = (int)(Math.random() * 20) + 1;
    static int guesses = 0;
    static String userInput;
    static int num = 0;
    public static String playerName = "";
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(Dialogue.intro);
        System.out.println(String.format(Dialogue.enter));
        playerName = scan.nextLine();
        if (playerName == null || playerName.isEmpty()) {
            playerName = "NoName";
            System.out.println(String.format(Dialogue.noName));
        }
        System.out.println(String.format(Dialogue.line1, playerName));
        //Start the guessing game.
        GuessTheNumber();

    }

    private static void GuessTheNumber() {
        do
        {
            userInput = scan.nextLine();
            try {
                num = Integer.parseInt(userInput);
                guesses++;
                AttemptNumber(num);
                }
             catch(Exception e)
            {
                System.out.println(String.format(Dialogue.enter2));
            }
        }
        while(num != privateNum);

        System.out.println(String.format(Dialogue.cont, playerName));
        boolean good = false;
        while(!good)
        {
        switch (userInput = scan.nextLine()) {
            case "Y":
            case "y":
                good = true;
                NewGame();
                break;
            case "N":
            case "n":
                System.out.println(String.format(Dialogue.end));
                return;
            default:
                System.out.println(String.format(Dialogue.enter3));
            }
        }
    }

    private static void NewGame() {
        System.out.println(String.format(Dialogue.newNum));
        privateNum = (int)(Math.random() * 20) + 1;
        guesses = 0;
        GuessTheNumber();
    }

    static void AttemptNumber(int guess) {
            if(guess == privateNum)
            {
                if(guesses == 1)
                {
                    System.out.println(String.format(Dialogue.firstTry));
                    return;
                }
                System.out.println(String.format(Dialogue.win, playerName, guesses));
                return;
            }
            if(guess > privateNum)
            {
                System.out.println(String.format(Dialogue.high));
                return;
            }
            if(guess < privateNum)
            {
                System.out.println(String.format(Dialogue.low));

            }
    }

}



