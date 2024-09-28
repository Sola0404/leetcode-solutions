package TopInterview150;

import java.util.HashMap;
import java.util.Map;

class Solutions {
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
}