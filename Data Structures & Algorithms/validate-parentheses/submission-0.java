class Solution {
  public boolean isValid(String s) {
    Stack<Character> par = new Stack<>();
    String open = "({[";
    String close = ")}]";

    for (char c : s.toCharArray()) {
      if (open.indexOf(c) != -1) {
        par.push(c);
      } else {
        if (!par.isEmpty() && close.indexOf(c) == open.indexOf(par.peek())) {
          par.pop();
        } else
          return false;
      }
    }
    return par.isEmpty();
  }
}
