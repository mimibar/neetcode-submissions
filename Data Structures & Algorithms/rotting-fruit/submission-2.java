class Solution {
  boolean shouldRot(int[][] grid, int i, int j) {
    if (grid[i][j] == 1) {
      if ((i > 0 && grid[i - 1][j] == 2) || (j > 0 && grid[i][j - 1] == 2)
          || (i < grid.length - 1 && grid[i + 1][j] == 2)
          || (j < grid[0].length - 1 && grid[i][j + 1] == 2))
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
    // System.out.println(fresh);

    boolean rotten = true;
    while (rotten && fresh > 0) {
      //   min++;
      rotten = false;
      List<int[]> toRot = new LinkedList<>();
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (shouldRot(grid, i, j)) {
            toRot.add(new int[] {i, j});
          }
        }
      }
      if (!toRot.isEmpty()) {
        rotten = true;
        min++;
        // System.out.println(min + "-" + fresh);

        for (int[] cell : toRot) {
          grid[cell[0]][cell[1]] = 2;
          fresh--;
        }
      }
    }
    // System.out.println(fresh);
    return fresh == 0 ? min : -1;
  }
}
