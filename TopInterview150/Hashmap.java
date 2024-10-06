package TopInterview150;

import java.util.HashMap;
import java.util.Map;

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
}
