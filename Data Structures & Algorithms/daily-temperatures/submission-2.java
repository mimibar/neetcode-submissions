class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    //using Stack instead of PriorityQueue
    // only store index instead of index and value
    Stack<Integer> pq = new Stack<>();
    int[] result = new int[temperatures.length];

    for (int i = 0; i < temperatures.length; i++) {
      while (!pq.isEmpty() && temperatures[pq.peek()] < temperatures[i]) {
        int day = pq.pop();
        result[day] = i - day;
      }
      pq.add(i);
    }
    return result;
  }
}
