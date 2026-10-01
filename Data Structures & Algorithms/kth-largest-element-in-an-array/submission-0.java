class Solution {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int n : nums) {
      if (pq.isEmpty() || n > pq.peek())
        pq.add(n);
      if (pq.size() > k)
        pq.poll();
    }
    return pq.peek();
  }
}
