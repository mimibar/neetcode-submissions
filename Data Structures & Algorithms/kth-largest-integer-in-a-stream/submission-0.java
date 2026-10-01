class KthLargest {
  int k = 0;
  PriorityQueue<Integer> pq = new PriorityQueue<>();
  public KthLargest(int k, int[] nums) {
    this.k = k;
  }

  public int add(int val) {
    pq.add(val);
    if (pq.size() > k)
      pq.poll();
    return pq.peek();
  }
}
