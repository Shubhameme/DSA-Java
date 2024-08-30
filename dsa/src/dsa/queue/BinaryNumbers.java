package dsa.queue;

import java.util.ArrayList;
import java.util.List;

public class BinaryNumbers {
    public static void main(String[] args) {
        int n = 5; // Generate binary numbers from 1 to 5
        List<String> binaryNumbers = generateBinaryNumbers(n);
                
        for (String binary : binaryNumbers) {
            System.out.println(binary);
        }
    }

    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(Integer.toBinaryString(i));
        }
        return result;
    }
}

