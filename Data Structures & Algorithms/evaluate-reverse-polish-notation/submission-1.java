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
            nums.push(nums.pop() - a);
          }
          case "*" -> nums.push(nums.pop() * nums.pop());
          case "/" -> {
            int a = nums.pop();
            nums.push(nums.pop() / a);
          }
        }
      } else
        nums.push(Integer.valueOf(t));
    }
    return nums.pop();
  }
}
