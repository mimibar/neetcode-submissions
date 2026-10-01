class Solution {
  double euclideanDistance(int[] xy) {
    return Math.sqrt(Math.pow(0 - xy[0], 2) + Math.pow(0 - xy[1], 2));
  }

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(
        (a, b) -> Double.compare(euclideanDistance(points[b]), euclideanDistance(points[a])));

    for (int i = 0; i < points.length; i++) {
      pq.add(i);
      if (pq.size() > k)
        pq.poll();
    }
    int[][] res = new int[k][2];
    for (int i = 0; i < k; i++) {
        res[i]=points[pq.poll()];
    }
    return res;
  }
}
