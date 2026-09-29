class Solution {
  public int evalRPN(String[] tokens) {
    String ops = "+-*/";

    Stack<Integer> nums = new Stack<>();
    for (String t : tokens) {
      if (ops.contains(t)) {
        switch (t) {
          case "+" -> nums.push(nums.pop() + nums.pop());
          case "-" -> {
            int a = nums.pop();
            nums.push(a - nums.pop());
          }
          case "*" -> nums.push(nums.pop() * nums.pop());
          case "/" -> {
            int a = nums.pop();
            nums.push(a / nums.pop());
          }
        }
      } else
        nums.push(Integer.valueOf(t));
    }
    return nums.pop();
  }
}
