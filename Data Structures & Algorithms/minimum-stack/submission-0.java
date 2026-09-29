class MinStack {
  PriorityQueue<Integer> pq = new PriorityQueue<>();
  Stack<Integer> stack = new Stack<>();
  public MinStack() {}

  public void push(int val) {
    pq.add(val);
    stack.push(val);
  }

  public void pop() {
    pq.remove(stack.pop());
    
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return pq.peek();
  }
}
