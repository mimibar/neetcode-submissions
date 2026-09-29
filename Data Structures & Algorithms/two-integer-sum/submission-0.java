class Solution {
  public int[] twoSum(int[] nums, int target) {
    Arrays.sort(nums);
    for (int n : nums) {
      if (bsearch(nums, target - n))
        return new int[] {n, target - n};
    }
    return new int[]();
  }
}
