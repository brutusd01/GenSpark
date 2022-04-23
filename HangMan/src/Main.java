import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static String wordToGuess = "cat";
    public static String hiddenAnswer = "";
   // public static char[] answerArray;
    public static ArrayList<String> missedWords = new ArrayList<>();
    public static int guessesLeft = 6;
    public static StringBuilder sb;
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        for (int i = 0; i < wordToGuess.length(); i++) {
            hiddenAnswer += "_";
        }

        sb = new StringBuilder(hiddenAnswer);

        System.out.println("H A N G   M A N");
        System.out.println(String.format("Guess the word:" +
                "%n%s",hiddenAnswer));
        do
        {
            try
            {
                var input = scan.next();
                GuessWord(input);
                System.out.println(sb);

            } catch (Exception e)
            {
                System.out.println("Caught exception, type in words only.");
            }

        }while(guessesLeft > 0);
        if(guessesLeft == 0)
        {
            GameOver();
        }

    }

    private static void GameOver() {
        System.out.println("Game Over! Want to try again?");
    }

    private static void GuessWord(String guess)
    {
        char correct;
        if(guess.length() != 1) {
            System.out.println("Try typing in just 1 letter.");
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
                "%nWordsGuessed: %s",guessesLeft,missedWords));
    }
}
