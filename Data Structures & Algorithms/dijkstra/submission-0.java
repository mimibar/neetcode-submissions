class Solution {
  /**
  *
  [u,v,w]
  edges = [[0,1,10], [0,2,3]
  */
  public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
    Map<Integer, Integer> dist = new HashMap<>();
    for (int i = 0; i < n; i++) {
      dist.put(i, -1);
    }
    Map<Integer, Map<Integer, Integer>> adj = new HashMap<>(n);

    for (List<Integer> edge : edges) {
      int u = edge.get(0);
      int v = edge.get(1);
      int w = edge.get(2);
      Map<Integer, Integer> uv = adj.getOrDefault(u, new HashMap<>(n));
      uv.put(v, w);
      adj.put(u, uv);
    }

    LinkedList<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[n];
    visited[src] = true;
    dist.put(src, 0);
    for (Map.Entry<Integer, Integer> edge : adj.get(src).entrySet()) {
      int v = edge.getKey();
      int w = edge.getValue();
      dist.put(v, w);
      visited[v] = true;
      queue.push(v);
    }
    while (!queue.isEmpty()) {
      int u = queue.pop();
      if (adj.containsKey(u)) {
        Map<Integer, Integer> uv = adj.get(u);

        for (Map.Entry<Integer, Integer> edge : uv.entrySet()) {
          int v = edge.getKey();
          int w = edge.getValue();
          System.out.println(dist.get(v) + "-" + (dist.get(u) + w));
          if (dist.get(v) == -1 || (dist.get(u) + w < dist.get(v)))
            dist.put(v, dist.get(u) + w);
          if (!visited[v]) {
            visited[v] = true;
            queue.push(v);
          }
        }
      }
    }
    return dist;
  }
}
