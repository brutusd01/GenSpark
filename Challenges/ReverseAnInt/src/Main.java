public class Main {

    public static void main(String[] args) {
	// write your code here
        int number = 5531;
        System.out.println(String.format("Int was %s, but reversed is now %s",number,ReverseInt(number)));

    }

    public static int ReverseInt(int input)
    {
        String intToString = "" + input;
        String reverse = "";
        for (int i = 0; i < intToString.length(); i++) {
            char ch = intToString.charAt(i);
            reverse = ch+reverse;
        }
        return Integer.valueOf(reverse);
    }
}
