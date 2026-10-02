class Solution {
  // two pointers + Floyd
  public int findDuplicate(int[] nums) {
    int i = nums[0], j = nums[nums[0]];
    int n = nums.length;

    //   Hint 3 Use Floyd's cycle detection algorithm.
    //   Initialize a slow and a fast pointer at index 0. Repeatedly move  the fast pointer two
    //   steps with fast = nums[nums[fast]] untilthey meet.

    // Part 1) find a point in cycle
    while (i != j) {
      i = nums[i];
      j = nums[nums[j]];
    }

    // Part 2) traverse list and cycle until they meet
    int k = 0;
    while (i != k) {
      i = nums[i];
      k = nums[k];
    }

    // The meeting point is the duplicate number.

    return i;
  }
}
