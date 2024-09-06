import java.util.HashMap;
import java.util.Map;

public class stringsubsq {

    public static boolean isSubSequence(String str, String seq) {
        int i = 0;
        int j = 0;

        while (i < str.length() && j < seq.length()) {
            if (str.charAt(i) == seq.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == seq.length();
    }

    public static int firstNonReapetingChar(String str){
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        char[] chars = str.toCharArray();

        // Build frequency map
        for (char ch : chars) {
            characterFrequencyMap.put(ch, characterFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Find first non-repeating character
        for (int i = 0; i < str.length(); i++) {
            if (characterFrequencyMap.get(str.charAt(i)) == 1) {
                return i;  // Return index of first non-repeating character
            }
        }

        return -1;  // Return -1 if no non-repeating character found
    }

    

    public static void main(String[] args) {
        String str = "codinginterview";
        String seq = "con";

        System.out.println(isSubSequence(str, seq));

        int index = firstNonReapetingChar(str);
        if (index != -1) {
            System.out.println("First non-repeating character: " + str.charAt(index) + " at index " + index);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
