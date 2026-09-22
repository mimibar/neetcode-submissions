class Solution {
  int flood(int[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
      return 0;
    grid[i][j] = 0;
    return 1 + flood(grid, i - 1, j) + flood(grid, i, j - 1) + flood(grid, i + 1, j)
        + flood(grid, i, j + 1);
  }

  public int maxAreaOfIsland(int[][] grid) {
    int max = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, flood(grid, i, j));
        }
      }
    }
    return max;
  }
}
