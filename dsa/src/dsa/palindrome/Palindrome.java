package dsa.palindrome;

public class Palindrome {
	
	public static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length()-1;
		
		while(start < end){
			if(str.charAt(start)!= str.charAt(end)) {
				return false;
			}
			start ++;
			end --;
		}
		return true;
		
	}
	public static void main(String[] args) {
		String str = "madam";
		String str1 = "what";
		
		System.out.print(isPalindrome(str));
		System.out.println();
		System.out.print(isPalindrome(str1));
	}

}
