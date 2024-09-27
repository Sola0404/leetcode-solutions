package TopInterview150;

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
}