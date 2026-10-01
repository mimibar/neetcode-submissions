class Solution {
  public int search(int[] nums, int target, int left, int right) {
    if (left >= right)
      return -1;
    int mid = left + (right - left) / 2;
    if (nums[mid] == target)
      return mid;
    int res = -1;
    if (nums[mid] < target)
      res = search(nums, target, left, mid);
    if (res != -1)
      return res;

    return search(nums, target, mid + 1, right);
  }

  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length);
  }
}
