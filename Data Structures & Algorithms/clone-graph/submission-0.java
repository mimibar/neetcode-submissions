/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
  Map<Node, Node> clones = new HashMap<>();
  Stack<Node> queue = new Stack<>();

  public Node cloneGraph(Node node) {
    if (node == null)
      return null;
    queue.push(node);
    clones.put(node, new Node(node.val));
    while (!queue.isEmpty()) {
      Node n = queue.pop();
      Node clone = clones.get(n);
      for (Node neighbor : n.neighbors) {
        if (!clones.containsKey(neighbor)) {
          clones.put(neighbor, new Node(neighbor.val));
          queue.push(neighbor);
        }
        clone.neighbors.add(clones.get(neighbor));
      }
    }
    return clones.get(node);
  }
}