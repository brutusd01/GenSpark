import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String[] words = {"cat", "devious", "genspark", "java", "gosling", "reptilia", "megadeth" };
    public static String wordToGuess = "";
    public static String hiddenAnswer = "";
    public static ArrayList<String> missedWords = new ArrayList<>();
    public static int guessesLeft = 6;
    public static StringBuilder sb;
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        HangMan();
        GameOver(false);
    }

    private static void HangMan() {
        ResetGame();
        do
        {
            if(sb.toString().contains(wordToGuess)) {
            GameOver(true);
            return;
        }
            try
            {
                var input = scan.next();
                GuessWord(input);
                System.out.println(sb);
            } catch (Exception e)
            {
                System.out.println("Caught exception: Invalid input type.");
            }

        }while(guessesLeft > 0);
    }

    public static void ResetGame() {
        int random = (int)(Math.random() * words.length);
        wordToGuess = words[random];
        hiddenAnswer = "";
        for (int i = 0; i < wordToGuess.length(); i++) {
            hiddenAnswer += "_";
        }
        sb = new StringBuilder(hiddenAnswer);
        System.out.println("H A N G   M A N");
        System.out.println(String.format("Guess the word:" +
                "%n%s",hiddenAnswer));
    }

    public static void GuessWord(String guess)
    {
        if(missedWords.contains(guess) || sb.toString().contains(guess))
        {
            System.out.println(String.format("%nYou already guessed that letter. Pick a new one."));
            return;
        }

        char correct;
        if(guess.length() != 1) {
            System.out.println(String.format("%nTry typing in just 1 letter."));
            return;
        }

        System.out.println(String.format("\033[1m%s\033[0m",guess));
        if(wordToGuess.contains(guess)) //if its a correct guess
        {
            int index = wordToGuess.indexOf(guess);
            correct = guess.charAt(0);
            sb.setCharAt(index,correct);

            return;
        }
        else //if you got a wrong guess
            guessesLeft--;
            if(!missedWords.contains(guess))missedWords.add(guess);
        System.out.println(String.format("%n%s guesses left." +
                "%nWordsGuessed: %s",guessesLeft,missedWords.toString()));
    }

    public static void GameOver(boolean won) {
        if(!won)System.out.println(String.format("%nThe word was %s. You lost.",wordToGuess));
        else if(won)System.out.println(String.format("%nCorrect! The word was %s.",wordToGuess));
        System.out.println(String.format("%nWant to try again? (Y/N)"));
        boolean good = false;
        while(!good) {
            switch (scan.next().toString()) {
                case "Y":
                case "y":
                    good = true;
                    HangMan();
                    break;
                case "N":
                case "n":
                    System.exit(0);
            }
        }
    }
}
