class Solution {
  public int leastInterval(char[] tasks, int n) {
    if (n == 0)
      return tasks.length;
    int[] abc = new int[26];
    PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> Integer.compare(abc[j], abc[i]));

    for (char t : tasks) {
      abc[t - 'A']++;
    }

    int c = 0;
    while (Arrays.stream(abc).sum() > 0) {
      for (int i = 0; i < 26; i++) {
        if (abc[i] > 0)
          pq.add(i);
      }
      int cnt = pq.size();
      //   System.out.println(Arrays.toString(abc));
      //   System.out.println (pq.size());
      //   System.out.println(Math.abs(n - pq.size()+1));
      while (!pq.isEmpty()) {
        abc[pq.poll()]--;
        c++;
      }
      int sum = Arrays.stream(abc).sum();
      if (sum >= cnt && sum > 0)
        c += Math.abs(n - cnt + 1); // cooldown
    }
    return c;
  }
}
