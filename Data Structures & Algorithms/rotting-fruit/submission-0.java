class Solution {
  boolean shouldRot(int[][] grid, int i, int j) {
    if (grid[i][j] == 1) {
      if (i > 0 && i < grid.length && grid[i - 1][j] == 2)
        return true;
      if (i < grid.length - 1 && grid[i + 1][j] == 2)
        return true;
      if (j > 0 && grid[i][j - 1] == 2)
        return true;
      if (j < grid[0].length - 1 && grid[i][j + 1] == 2)
        return true;
    }
    return false;
  }
  public int orangesRotting(int[][] grid) {
    int min = 0;
    int fresh = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1)
          fresh++;
      }
    }
    if (fresh == 0)
      return min;

    boolean rotten = true;
    while (rotten && fresh > 0) {
      //   min++;
      rotten = false;
      List<int[]> toRot = new LinkedList<>();
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] == 1 && shouldRot(grid, i, j)) {
            toRot.add(new int[] {i, j});
          }
        }
        if (!toRot.isEmpty()) {
          rotten = true;
          min++;
          for (int[] cell : toRot) {
            grid[cell[0]][cell[1]] = 2;
            fresh--;
          }
        }
      }
    }
    return min > 0 ? min : -1;
  }
}
