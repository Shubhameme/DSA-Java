package dsa.array;

public class Palindrome {
	
	public boolean isPalindrome(String word) {
		char[] charArray = word.toCharArray();
		int start = 0;
		int end = word.length()-1;
		
		while(start<end) {
			if(charArray[start] != charArray[end]) {
				return false;
			} start ++;
			end --;
		}
		return true;
	}

	
	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		if(palindrome.isPalindrome("madam")) {
			System.out.println("the string is palindrome");
		}else {
			System.out.println("the string is not palindrome");
		}
		
	}

}
