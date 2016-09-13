import java.util.*;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> anagrams = anagrams("seat");
		System.out.println(anagrams);
		
		for (String anagram: anagrams) {
			System.out.println(isAnagram1(anagram, "seat") + "; " + isAnagram2(anagram, "seat"));
		}

		System.out.println(isAnagram1("sea", "seat") + "; " + isAnagram2("sea", "seat"));
		System.out.println(isAnagram1("beat", "seat") + "; " + isAnagram2("beat", "seat"));
		System.out.println(isAnagram1("sear", "seat") + "; " + isAnagram2("sear", "seat"));
	}
	
	/*
	 * Get the valid anagrams of a string
	 */
	public static List<String> anagrams(String str) {
		List<String> permutations = permutations("seat");
		List<String> result = new ArrayList<String>();
		for (String perm: permutations) {
			if (isAWord(perm)) {
				result.add(perm);
			}
		}
		
		return result;
	}
	
	/*
	 * Get the permutations of a string using recursion
	 * Time complexity: O(n!)
	 */
	public static List<String> permutations(String str) {
		if (str == null) return null;
		if (str.isEmpty()) {
			List<String> result = new ArrayList<String>();
			result.add("");
			return result;
		}
		List<String> result = new ArrayList<String>();
		int length = str.length();
		for (int i = 0; i < length; i++) {
			char c = str.charAt(i);
			String substring = str.substring(0, i) + str.substring(i + 1, length);
			
			List<String> resultOfRest = permutations(substring);
			for (String rest: resultOfRest) {
				result.add(c + rest);
			}
		}
		
		return result;
	}
	
	
	/*
	 * Store character counts into two maps
	 * And then compare the maps
	 * time O(m+n); space O(m+n)
	 */
	public static boolean isAnagram2(String str1, String str2) {
		if (str1 == null && str2 == null) return true;
		if (str1 == null || str2 == null) return false;
		if (str1.length() != str2.length()) return false;
		
		Map<Character, Integer> map1 = charCount(str1);
		Map<Character, Integer> map2 = charCount(str2);
		
		for (Character c: map1.keySet()) {
			if (!map2.containsKey(c)) {
				return false;
			}
			
			if (map1.get(c) != map2.get(c)) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Get the character count map of a String
	 */
	private static Map<Character, Integer> charCount(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		if (str == null) return map;
		
		for (char c: str.toCharArray()) {
			Integer count = map.get(c);
			if (count == null) {
				count = 0;
			}
			
			count++;
			map.put(c, count);
		}
		
		return map;
	}
	
	/*
	 * Sort and compare
	 * time O(mlogm + nlogn), space O(1)
	 */
	public static boolean isAnagram1(String str1, String str2) {
		if (str1 == null && str2 == null) return true;
		if (str1 == null || str2 == null) return false;
		
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		str1 = new String(chars1);
		str2 = new String(chars2);
		return str1.equals(str2);
	}
	
	/*
	 * Check if a string is a valid word
	 * Simple version. No need to implement it
	 */
	private static boolean isAWord(String str) {
		String[] validWords = new String[] {"east", "eats", "sate", "seat", "teas", "eat", "ate", "tea", "sat", "set", "sea", "as", "at" };
		List<String> words = Arrays.asList(validWords);
		
		return words.contains(str);
	}

}
