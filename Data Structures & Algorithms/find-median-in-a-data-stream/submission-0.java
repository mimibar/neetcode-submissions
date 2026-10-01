class MedianFinder {
  PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
  PriorityQueue<Integer> big;
  int n;
  public MedianFinder() {
    small = new PriorityQueue<>();
    big = new PriorityQueue<>();
  }

  public void addNum(int num) {
    small.add(num);
    if (small.size() > big.size()) {
      big.add(small.poll());
      small.add(num);
    } else
      big.add(num);
    n++;
  }

  /**
   * Recommended Time & Space Complexity
   * O(1) time for findMedian()
   * and O(n) space
   */
  public double findMedian() {
    return (n % 2 == 0) ? (double)(small.peek() + big.peek()) / 2 : small.peek();
  }
}
