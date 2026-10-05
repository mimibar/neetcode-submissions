class Solution {
  int bsearch(int[] numbers, int l, int r, int target) {
    if (l >= r)
      return -1;

    int mid = l + (r - l) / 2;
    if (numbers[mid] == target)
      return mid;
    if (numbers[mid] < target)
      return bsearch(numbers, mid + 1, r, target);
    return bsearch(numbers, l, mid, target);
  }
  public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    for (i = 0; i < numbers.length - 1; i++) {
      j = bsearch(numbers, i + 1, numbers.length, target - numbers[i]);
      if (j != -1) {
        break;
      }
    }
    return new int[] {i + 1, j + 1};
  }
}
