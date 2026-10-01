class Solution {
  boolean bSearchRow(int[] row, int target, int l, int r) {
    if (l >= r)
      return false;
    int mid = l + (r - l) / 2;
    if (row[mid] == target)
      return true;
    if (row[mid] < target)
      return bSearchRow(row, target, mid + 1, r);
    return bSearchRow(row, target, l, mid);
  }
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      if (bSearchRow(matrix[i], target, 0, n))
        return true;
    }
    return false;
  }
}
