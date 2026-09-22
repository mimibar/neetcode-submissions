class Solution {
  void flood(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
      return;
    grid[i][j] = '0';
    flood(grid, i - 1, j);
    flood(grid, i, j - 1);
    flood(grid, i + 1, j);
    flood(grid, i, j + 1);
  }
  public int numIslands(char[][] grid) {
    int num = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          num++;
          flood(grid, i, j);
        }
      }
    }
    return num;
  }
}
