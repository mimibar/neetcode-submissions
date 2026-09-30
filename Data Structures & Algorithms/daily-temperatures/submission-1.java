class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    //using Stack instead of PriorityQueue
    Stack<int[]> pq = new Stack<>();
    int[] result = new int[temperatures.length];

    for (int i = 0; i < temperatures.length; i++) {
      while (!pq.isEmpty() && pq.peek()[1] < temperatures[i]) {
        int[] day = pq.pop();
        result[day[0]] = i - day[0];
      }
      pq.add(new int[] {i, temperatures[i]});
    }
    return result;
  }
}
