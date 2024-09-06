import java.util.Set;

public class RemoveVowels {

    public static String removeVowels(String str){
        Set<Character> vowels = Set.of('a','e','i','o','u');
        StringBuilder sb = new StringBuilder();

       char[] chars =  str.toCharArray();

       for(Character ch: chars){
           if(!vowels.contains(ch)){
               sb.append(ch);
           }


       }
       return sb.toString();
    }


    public static void main(String[] args) {
        RemoveVowels rv = new RemoveVowels();

        System.out.println(removeVowels("im shubham"));
    }
}
