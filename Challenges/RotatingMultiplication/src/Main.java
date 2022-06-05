import java.util.Arrays;

public class Main {

    static int[] nums = {2,6,5,4};

    public static void main(String[] args)
    {
       System.out.print(Arrays.toString(product(nums)));
    }

    public static int[] product(int[]ints)
    {
        int[]product = new int[ints.length];

        for (int i = 0; i < ints.length; i++)
        {
        int multi = 1;
            for (int j = 0; j < ints.length; j++)
            {
                if(i!=j)
                {
                    System.out.println(String.format("i:%s ,j:%s, multiplying..",ints[i],ints[j]));
                    multi *= ints[j];
                    System.out.println(String.format("product of %s,%s: %s",ints[i],ints[j],multi));
                }
            }
            product[i] = multi;
        }

        return product;
    }
}
