package TopInterview150;

public class MathSolution {
  public boolean isPalindrome(int x) {
    String s = String.valueOf(x);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i))
        return false;
    }
    return true;
  }

  // 66. Plus One
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      } else {
        digits[i] = 0;
      }
    }
    int[] newDigits = new int[digits.length + 1];
    newDigits[0] = 1;
    return newDigits;
  }
}
