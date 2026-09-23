class Solution {
  int m = 0;
  int n = 0;
  void notCapture(char[][] board, int i, int j) {
    if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O')
      return;
    board[i][j] = '-';
    notCapture(board, i - 1, j);
    notCapture(board, i + 1, j);
    notCapture(board, i, j - 1);
    notCapture(board, i, j + 1);
  }

  public void solve(char[][] board) {
    m = board.length;
    n = board[0].length;

    for (int i = 0; i < m; i++) {
      notCapture(board, i, 0);
      notCapture(board, i, n - 1);
    }
    for (int j = 0; j < n; j++) {
      notCapture(board, 0, j);
      notCapture(board, m - 1, j);
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // capture
        if (board[i][j] == 'O')
          board[i][j] = 'X';
        // restore
        if (board[i][j] == '-')
          board[i][j] = 'O';
      }
    }
  }
}
