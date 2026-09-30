class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
    Map<Integer, int[]> map = new HashMap<>();

    for (int num : nums) {
      int[] a = map.getOrDefault(num, new int[2]);
      if (pq.contains(a))
        pq.remove(a);
      a[0] = num;
      a[1]++;
      map.put(num, a);
      pq.add(a);
    }
    int[] res = new int[k];
    int i = 0;
    while (i < k) {
      res[i] = pq.poll()[0];
      i++;
    }
    return res;
  }
}
