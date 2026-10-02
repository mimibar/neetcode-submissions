class Solution {
  // two pointers
  public int findDuplicate(int[] nums) {
    int i = 0, j = 1;
    int n = nums.length;

    while (nums[i] != nums[j]) {
      j += 2;
      j %= n;
      if (j == i) {
        j += 2;
        j %= n;
      }
      i++;
      i %= n;
    }
    return nums[i];
  }
}
