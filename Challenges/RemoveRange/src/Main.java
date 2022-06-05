import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,5,6,7,8,9,10));
        RemoveRange(1,5,nums);
        System.out.println(nums);
    }

    public static void RemoveRange(int from, int to, ArrayList list)
    {
        for (int i = from; i <= to; i++) {

            if(list.contains(i))
            {
                list.remove(Integer.valueOf(i));
            }
        }
    }
}
