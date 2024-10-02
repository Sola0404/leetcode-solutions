package TopInterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  // 392. Is Subsequence
  public boolean isSubsequence(String s, String t) {
    int i = 0;
    int j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
      } else {
        j++;
      }
    }
    return i == s.length();
  }

  // 167. Two Sum II - Input Array Is Sorted
  public int[] twoSum1(int[] numbers, int target) {
    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[i] + numbers[j] == target) {
          return new int[] { i + 1, j + 1 };
        }
      }
    }

    return new int[2];
  }

  // 167. Two Sum II - Input Array Is Sorted (Better Solution)
  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum == target)
        return new int[] { left + 1, right + 1 };
      else if (sum < target)
        left++;
      else if (sum > target)
        right--;
    }
    return new int[2];
  }

  // 11. Container With Most Water
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxArea = 0;
    while (left < right) {
      int h = Math.min(height[left], height[right]);
      int w = right - left;
      int area = h * w;
      maxArea = Math.max(area, maxArea);
      if (height[left] < height[right])
        left++;
      else
        right--;
    }
    return maxArea;
  }

  // 15. 3Sum
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> lists = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j]);
          list.add(nums[k]);
          set.add(list);
          j++;
          k--;
        } else if (sum > 0)
          k--;
        else
          j++;
      }
    }

    lists.addAll(set);
    return lists;
  }
}
