package TopInterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hashmap {
  // 383. Ransom Note
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] counter = new int[26];
    for (char c : magazine.toCharArray()) {
      counter[c - 'a']++;
    }

    for (char c : ransomNote.toCharArray()) {
      if (counter[c - 'a'] == 0)
        return false;
      counter[c - 'a']--;
    }

    return true;
  }

  // 205. Isomorphic Strings
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      if (!map.keySet().contains(c1)) {
        if (map.values().contains(c2))
          return false;
        map.put(c1, c2);
      } else {
        if (map.get(c1) != c2)
          return false;
      }
    }
    return true;
  }

  // 290. Word Pattern
  public boolean wordPattern(String pattern, String s) {
    Map<Character, String> map = new HashMap<>();
    String[] words = s.split(" ");

    if (words.length != pattern.length())
      return false;
    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.toCharArray()[i];
      if (map.keySet().contains(c)) {
        if (!map.get(c).equals(words[i]))
          return false;
      } else {
        if (map.values().contains(words[i]))
          return false;
        map.put(c, words[i]);
      }
    }

    return true;
  }

  // 242. Valid Anagram
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
      return false;

    int[] chars = new int[26];

    for (char c : s.toCharArray()) {
      chars[c - 'a']++;
    }

    for (char c : t.toCharArray()) {
      if (chars[c - 'a'] == 0)
        return false;
      chars[c - 'a']--;
    }
    return true;
  }

  // 49. Group Anagrams
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String sortedString = new String(chars);

      if (!map.containsKey(sortedString))
        map.put(sortedString, new ArrayList<>());

      map.get(sortedString).add(s);
    }

    return new ArrayList<>(map.values());
  }

  // 1. Two Sum
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    return new int[] {};
  }

  // 202. Happy Number
  public boolean isHappy(int n) {
    Set<Integer> visited = new HashSet<>();

    while (!visited.contains(n)) {
      visited.add(n);
      n = getNextNum(n);
      if (n == 1) {
        return true;
      }
    }

    return false;
  }

  private int getNextNum(int n) {
    int output = 0;
    while (n > 0) {
      int digit = n % 10;
      output += digit * digit;
      n /= 10;
    }
    return output;
  }
}
