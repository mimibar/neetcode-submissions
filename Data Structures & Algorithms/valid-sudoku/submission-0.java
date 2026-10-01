class Solution {
  boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }
  boolean isDot(char c) {
    return c == '.';
  }
  boolean isValid(boolean[] num, char c) {
    return isDigit(c) && !num[c - '0'] || isDot(c);
  }
  boolean isRowValid(char[][] board, final int i) {
    boolean[] num = new boolean[10];
    for (int j = 0; j < board[0].length; j++) {
      System.out.println(board[i][j] - '0');
      if (!isValid(num, board[i][j]))
        return false;
      if (!isDot(board[i][j]))
        num[board[i][j] - '0'] = true;
    }
    return true;
  }
  boolean isColValid(char[][] board, final int j) {
    boolean[] num = new boolean[10];
    for (int i = 0; i < board.length; i++) {
      if (!isValid(num, board[i][j]))
        return false;
      if (!isDot(board[i][j]))
        num[board[i][j] - '0'] = true;
    }
    return true;
  }
  boolean isSquareValid(char[][] board, int a, int b) {
    boolean[] num = new boolean[10];
    for (int i = a; i < a + 3; i++) {
      for (int j = b; j < b + 3; j++) {
        if (!isValid(num, board[i][j]))
          return false;
        if (!isDot(board[i][j]))
          num[board[i][j] - '0'] = true;
      }
    }
    return true;
  }
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      if (!isRowValid(board, i))
        return false;
      for (int j = 0; j < board[0].length; j++) {
        if (!isColValid(board, j))
          return false;
        if (i % 3 == 0 && j % 3 == 0 && !isSquareValid(board, i, j))
          return false;
      }
    }

    return true;
  }
}
