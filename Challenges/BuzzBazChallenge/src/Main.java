public class Main {

    public static void main(String[] args) {
	//In your method you need to check to see if the integer is divisible by 3 and if it is then you will need to return fizz,
        // if it's divisible by 5 then return buzz, and lastly if it's divisible by 3 and 5 return fizz buzz bazz.
       System.out.println(Buzz(5));
        System.out.println(Buzz(15));
        System.out.println(Buzz(3));

         int x = 1;
                do{

                    System.out.println("Do While Loop...");
                }while (x<5);

    }

    public static String Buzz(int input)
    {
        if(input % 5 == 0 && input % 3 == 0 )
        {
            return "fizz buzz bazz";
        }
        if(input % 5 == 0)
        {
            return "buzz";
        }
        if(input % 3 == 0)
        {
            return "fizz";
        }
        return null;
    }
}
