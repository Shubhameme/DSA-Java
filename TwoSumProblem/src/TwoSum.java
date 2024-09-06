import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] TwoSum(int[] numbers,int target){

        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();


        for (int i =0;i<numbers.length;i++){
            int complement = target - numbers[i];
            if(map.containsKey(complement)){
                result [0] = map.get(complement);
                result [1] = i;
                return result;
            }
            map.put(numbers[i],i);
        }
        return new int[]{};
    }



    public static void main(String[] args) {
    TwoSum ts = new TwoSum();
    int[] numbers = new int[]{2,11,5,10,7,8};
    int[] result = TwoSum(numbers,9);
        System.out.println("Two indices are: ["+result[0] +","+result[1]+"]");
    }
}
