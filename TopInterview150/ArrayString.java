package TopInterview150;

import java.util.HashMap;
import java.util.Map;

class ArrayString {
  // 88. Merge Sorted Aarry
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int mIndex = m - 1;
    int nIndex = n - 1;
    int newIndex = nums1.length - 1;

    while (mIndex >= 0 && nIndex >= 0) {
      if (nums1[mIndex] > nums2[nIndex]) {
        nums1[newIndex] = nums1[mIndex];
        mIndex--;
      } else {
        nums1[newIndex] = nums2[nIndex];
        nIndex--;
      }
      newIndex--;
    }
    while (nIndex >= 0) {
      nums1[newIndex] = nums2[nIndex];
      nIndex--;
      newIndex--;
    }
  }

  // 27. Remove Element
  public int removeElement(int[] nums, int val) {
    int removeNum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i == nums.length - removeNum)
        break;
      if (nums[i] == val) {
        for (int j = i; j < nums.length - 1; j++) {
          nums[j] = nums[j + 1];
        }
        nums[nums.length - 1] = 0;
        removeNum++;
        i--;
      }
    }

    return nums.length - removeNum;
  }

  // 26. Remove Duplicates from Sorted Array
  public int removeDuplicates1(int[] nums) {
    if (nums.length == 0 || nums.length == 1) {
      return nums.length;
    }

    int uniqueNum = 1;
    int emptyNum = 0;
    int i = 1;
    while (i < nums.length) {
      if (i == nums.length - emptyNum)
        break;

      if (nums[i] == nums[i - 1]) {
        for (int j = i; j < nums.length; j++) {
          nums[j - 1] = nums[j];
        }
        nums[nums.length - 1] = 0;
        emptyNum++;
      } else {
        uniqueNum++;
        i++;
      }
    }
    return uniqueNum;
  }

  // 26. Remove Duplicates from Sorted Array (better solution)
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 1)
      return nums.length;

    int uniqueNum = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[uniqueNum - 1]) {
        nums[uniqueNum] = nums[i];
        uniqueNum++;
      }
    }
    return uniqueNum;
  }

  // 80. Remove Duplicates from Sorted Array II
  public int removeDuplicates2(int[] nums) {
    if (nums.length <= 2)
      return nums.length;

    int uniqueNum = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] != nums[uniqueNum - 2]) {
        nums[uniqueNum] = nums[i];
        uniqueNum++;
      }
    }
    return uniqueNum;
  }

  // 169. Majority Element
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      if (!map.keySet().contains(i))
        map.put(i, 1);
      else
        map.put(i, map.get(i) + 1);
    }

    for (int key : map.keySet()) {
      if (map.get(key) > nums.length / 2)
        return key;
    }

    return -1;
  }

  // 189. Rotate Array
  public void rotate(int[] nums, int k) {
    while (k >= nums.length) {
      k -= nums.length;
    }

    int[] part1 = new int[nums.length - k];
    int[] part2 = new int[k];
    for (int i = 0; i < nums.length; i++) {
      if (i < nums.length - k) {
        part1[i] = nums[i];
      } else {
        part2[i - nums.length + k] = nums[i];
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (i < k) {
        nums[i] = part2[i];
      } else {
        nums[i] = part1[i - k];
      }
    }
  }

  // 121. Best Time to Buy and Sell Stock
  public int maxProfit1(int[] prices) {
    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else {
        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
      }
    }

    return maxProfit;
  }

  // 122. Best Time to Buy and Sell Stock II
  public int maxProfit2(int[] prices) {
    int profit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        profit += (prices[i + 1] - prices[i]);
      }
    }
    return profit;
  }

  // 55. Jump Game
  public boolean canJump(int[] nums) {
    int maxLength = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (i > maxLength) {
        return false;
      }
      maxLength = Integer.max(nums[i] + i, maxLength);
      if (maxLength >= nums.length - 1) {
        return true;
      }
    }
    return true;
  }

  public static int jump(int[] nums) {
    int jumps = 0;
    int currentJumpEnd = 0;
    int farthest = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      farthest = Math.max(farthest, i + nums[i]);
      if (i == currentJumpEnd) {
        jumps++;
        currentJumpEnd = farthest;
      }
    }
    return jumps;
  }

  // 13. Roman to Integer
  public int romanToInt(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int result = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length - 1; i++) {
      int currentValue = map.get(chars[i]);
      int nextValue = map.get(chars[i + 1]);
      if (currentValue >= nextValue) {
        result += currentValue;
      } else {
        result -= currentValue;
      }
    }
    result += map.get(chars[chars.length - 1]);
    return result;
  }

  // 12. Integer to Roman
  public String intToRoman(int num) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < values.length; i++) {
      while (num >= values[i]) {
        num -= values[i];
        sb.append(symbols[i]);
      }
    }
    return sb.toString();
  }

  // 58. Length of Last Word
  public int lengthOfLastWord(String s) {
    String[] strings = s.split(" ");
    return strings[strings.length - 1].trim().length();
  }

  // 14. Longest Common Prefix
  public String longestCommonPrefix(String[] strs) {
    StringBuilder sb = new StringBuilder();

    int minLength = strs[0].length();
    for (String s : strs) {
      if (s.length() < minLength) {
        minLength = s.length();
      }
    }

    for (int i = 0; i < minLength; i++) {
      char shouldBe = strs[0].charAt(i);
      for (String s : strs) {
        if (s.charAt(i) != shouldBe)
          return sb.toString();
      }
      sb.append(shouldBe);
    }

    return sb.toString();
  }
}
