package TopInterview150;

public class TwoPointers {
  // 125. Valid Palindrome
  public boolean isPalindrome(String s) {
    s = s.toLowerCase().replaceAll("\\W+", "").replaceAll("_", "");

    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1))
        return false;
    }

    return true;
  }
}
