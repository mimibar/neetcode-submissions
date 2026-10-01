class MedianFinder {
  PriorityQueue<Integer> small ;
  PriorityQueue<Integer> big;
  int n;
  public MedianFinder() {
    small = new PriorityQueue<>(Collections.reverseOrder());
    big = new PriorityQueue<>();
  }

  public void addNum(int num) {
    // if (small.isEmpty())
    //   small.add(num);
    // else {
    big.add(num);
    if (big.size() - 1 > small.size()) {
      small.add(big.poll());
    }
    // }
    n++;
  }

  /**5372->2_35_7
  5
  5 3
  3 5
  3 57
  3 257
  53->3 5
  37 5->
   * Recommended Time & Space Complexity
   * O(1) time for findMedian()
   * and O(n) space
   */
  public double findMedian() {
    // System.out.println(Arrays.toString(small.toArray()) + " " + Arrays.toString(big.toArray()));
    // System.out.println(small.peek() + "-" + big.peek());
    return (n % 2 == 0) ? (double) (small.peek() + big.peek()) / 2 : big.peek();
  }
}
