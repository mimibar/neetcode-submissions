class Solution {
  // two pointers
  public int findDuplicate(int[] nums) {
    int j = 2;
    for (int i = 0; i < nums.length; i++) {
      if (j == i) {
        j += 2;
        continue;
      }
      if (nums[i] == nums[j])
        return nums[i];
    }
    return -1;
  }
}
