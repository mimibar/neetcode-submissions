class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    int[] result = new int[temperatures.length];

    for (int i = 0; i < temperatures.length; i++) {
      while (!pq.isEmpty() && pq.peek()[1] < temperatures[i]) {
        int[] day = pq.poll();
        result[day[0]] = i - day[0];
      }
      pq.add(new int[] {i, temperatures[i]});
    }
    return result;
  }
}
