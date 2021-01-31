package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1>len2) {
			return s1;
		}
		else if(len2>len1) {
			return s2;
		}
		else {
			return "equal";
		}
		
		
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		
		if(s.contains("underscores")) {
			s = s.replace(' ', '_');
			return s;
		}
		else {
			return s;
		}
		
		
		
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String news1 = s1.trim();
		String news2 = s2.trim();
		String news3 = s3.trim();
		
		int l1 = news1.length()-1;
		int l2 = news2.length()-1;
		int l3 = news3.length()-1;
		
		char char1 = news1.charAt(l1);
		char char2 = news2.charAt(l2);
		char char3 = news3.charAt(l3);
		
		
		if(char1<char2) {
			if(char1<char3) {
				return news1;
			}
		}
		else if(char2<char1) {
			if(char2<char3) {
				return news2;
			}
		}
		else {
			return news3;
		}
		return news3;
		

	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		int a  =  0;
		
		for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
	
				int num = Integer.parseInt(s.charAt(i)+"");
				sum = sum + num;
			
				
				
			
			}
			
		}

	
		
		return sum;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int times =  0;
		int index = 0;
		

		while(s.contains(substring)) {
			times++;
			index = s.indexOf(substring) + substring.length();
			s = s.substring(index);
			
	
	
	}
		
		
		return times;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		
		
		return Utilities.encrypt(s.getBytes(), (byte) key);
		
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		
		
		return Utilities.decrypt(s, (byte) key);
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int index = 0;
		int times = 0;
		
		while(s.contains(substring)) {
		
			if(s.indexOf(" ")-substring.length()==s.indexOf(substring)) {
				times++;
				index = s.indexOf(" ");
				s = s.substring(index);
				
				if(index==-1) {
					break;
				}
			}
			
			else if(s.indexOf(" ")==-1&&s.length()>=substring.length()) {
				if(s.length()-substring.length()==s.indexOf(substring)){
					times++;
					
					break;
				}
				else {
					s = s.substring(1);
				}
			}
			else {
				s = s.substring(1);
			}
		
		
			
		
			
		}
		
	
		return times;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		
		
		int start = s.indexOf(substring)+substring.length();
		int end = s.length()-substring.length();
		
		s = s.substring(start, end);
		
		
		
		
		return s.length();
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String reverseS = "";
		
		s = s.trim();
		s = s.replace(" ", "");
		s = s.replace(",", "");
		s = s.replace(":", "");
		s = s.replace(".", "");
		s = s.replace("–", "");
		s =  s.replace("?", "");
		s = s.toLowerCase();
	
		char[] indexS = s.toCharArray();
		for(int i = s.length()-1; i>=0; i--) {
			reverseS += indexS[i];
		}
		
		System.out.println(s);
		System.out.println(reverseS);
		
		if(reverseS.equals(s)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
