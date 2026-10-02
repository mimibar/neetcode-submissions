class Solution {
  // two pointers
  public int findDuplicate(int[] nums) {
    int i = 0, j = 1;
    int n = nums.length;

    while (nums[i] != nums[j]) {
      i++;
      i %= n;
      j += 2;
      j %= n;
      if (j == i) {
        j += 2;
        j %= n;
      }
    }
    return nums[i];
  }
}
