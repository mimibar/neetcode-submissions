class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      for (int j = i + 1; j < nums.length - 1; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1])
          continue;
        int k = Arrays.binarySearch(nums, j + 1, nums.length, -(nums[i] + nums[j]));
        if (k > 0)
          res.add(Arrays.asList(nums[i], nums[j], nums[k]));
      }
    }
    return res;
  }
}
