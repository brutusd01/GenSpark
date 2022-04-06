public class Main {

    public static void main(String[] args) {
	// write your code here
        //Game parameters
        int privateNum = (int)(Math.random() * 20) + 1;
        int guesses = 0;
        String playerName = "";

        //Dialogue lines!
        String intro = "Hello! Welcome to my game. First of all, what is your name?";
        String line1 = String.format("Well.. %s I have a number in mind." +
                "%nIt is between 1 and 20." +
                "%nTell me.. Can you guess it?", playerName);

        //Print the lines.
        System.out.println(intro);
        System.out.println(line1);
    }
}
