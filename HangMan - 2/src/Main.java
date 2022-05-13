import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String[] words = {"cat", "devious", "genspark", "java", "gosling", "reptilia", "megadeth" };
    public static String wordToGuess = "";
    public static StringBuilder hiddenAnswer = new StringBuilder();
    public static ArrayList<String> missedWords = new ArrayList<>();
    public static int guessesLeft = 6;
    public static int attempt = 0;
    public static Scanner scan = new Scanner(System.in);
    static int index = 0;
    public static float score = 0;
    public static String name = "";

    public static HighScore scores = new HighScore();

    public static void main(String[] args)
    {
        HangMan();
        GameOver(false);
    }

    static void hideAnswer()
    {
        hiddenAnswer.append("_");
        if(hiddenAnswer.length() != wordToGuess.length()) //Cheeky way to dodge a loop
            hideAnswer();
    }

    private static void HangMan() { //This runs the game
        NewGame();
        do //Loop until hiddenAnswer = wordToGuess
        {
            if(hiddenAnswer.toString().contains(wordToGuess))
            {
            GameOver(true);
            return;
            }
            try
            {
                var input = scan.next(); //Stores input
                if(!input.matches(".*[^a-z].*"))
                {
                GuessWord(input);
                }
                else
                    System.out.println("Lowercase letters only!");
            } catch (Exception e)
            {
                System.out.println("Caught exception: Invalid input type.");
            }

        }while(guessesLeft > 0);
    }

    public static void NewGame() {
        PrintIntro();
        score = 0;
        int random = (int)(Math.random() * words.length);
        wordToGuess = words[random];
        missedWords.removeAll(missedWords);
        hiddenAnswer = new StringBuilder();
        hideAnswer();
        System.out.println(String.format("\nGuess the word:" +
                "%n%s",hiddenAnswer));
    }

    private static void PrintIntro() {
        try
        {
            System.out.println(Files.readString(Paths.get("src/Resources/Intro.txt")));
        }catch (IOException e) {
            e.printStackTrace();
        }

        Wait(1000);

        System.out.println("Welcome to hangman, what is your name? [Enter Below]");
        name = new Scanner(System.in).nextLine();
        if(name.trim().equals("") || name.isBlank())
        {
            System.out.println("Okay buddy, your name is now TroutRazer since you didn't put in anything.");
            name= "TroutRazer";
            Wait(1000);
        }
    }

    private static void Wait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void GuessWord(String guess)
    {
        if(missedWords.contains(guess) || hiddenAnswer.toString().contains(guess))
        {
            System.out.println(String.format("%nYou already guessed that letter. Pick a new one."));
            return;
        }
        if(guess.length() != 1) {
            System.out.println(String.format("%nTry typing in just 1 letter."));
            return;
        }
        System.out.println(String.format("\033[1m%s\033[0m",guess)); //Print out the phrase
        Check(guess);
        try{
            Print();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Check(String input) {
        char correct;
        missedWords.add(input);
        if(wordToGuess.contains(input)) //if its a correct guess
        {
            System.out.println("Correct guess..");
            score += 100;
            correct = input.charAt(0);
            UpdateHint(correct);
            return;
        }
        else//if you got a wrong guess

            System.out.println("Incorrect..");
            attempt++;
            guessesLeft--;
            return;

    }

    private static void UpdateHint(char c) {
        if (index < wordToGuess.length()) {
            if (wordToGuess.charAt(index) == c)
            {
                hiddenAnswer.setCharAt(index,c);
            }
            index++;
            UpdateHint(c);
        }
        index = 0;
    }

    public static void Print() throws IOException {
        System.out.println(hiddenAnswer);
        System.out.println(Files.readString(Paths.get(String.format("src/Resources/Art%s.txt", attempt))));
        System.out.println(String.format("%n%s guesses left." +
                "%nWordsGuessed: %s", guessesLeft, missedWords.toString()));
    }

    public static void GameOver(boolean won) {
        score = score
                - (attempt * 50f) //Subtract the amount of wrong guesses
                + (wordToGuess.length() * 25f); //Add bonus points for a longer word
        if(!won)System.out.println(String.format("%nThe word was %s. You lost.",wordToGuess));
        else if(won)System.out.println(String.format("%nCorrect! The word was %s.",wordToGuess));
        if(scores.CheckForHigh(score))
        {
            System.out.println(String.format("%nSweet! You set the new high score of: %s",score));
        }
        else
        {
            System.out.println(String.format("%nYour score is: %s",score));
        }
        scores.SaveScore(name, score);
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
