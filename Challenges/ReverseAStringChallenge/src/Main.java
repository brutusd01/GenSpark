public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(iterativeReverse("Genspark"));
        System.out.println(functionalReverse("Java time!"));

    }
    public static String iterativeReverse(String input)
    {
        String reversed = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            reversed = c + reversed;
        }
        return reversed;
    }

    public static StringBuilder functionalReverse(String input)
    {
        StringBuilder reversed = new StringBuilder(input);

        reversed.reverse();

        return reversed;
    }

}



