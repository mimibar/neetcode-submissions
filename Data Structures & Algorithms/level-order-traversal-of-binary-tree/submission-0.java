/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    if (root == null)
      return res;
    res.add(Arrays.asList(root.val));

    LinkedList<TreeNode> level = new LinkedList<>();
    if (root.left != null)
      level.add(root.left);
    if (root.right != null)
      level.add(root.right);
    List<Integer> l;

    while (!level.isEmpty()) {
      LinkedList<TreeNode> curLevel = new LinkedList<>();
      l = new LinkedList<>();
      while (!level.isEmpty()) {
        TreeNode n = level.removeFirst();
        l.add(n.val);
       if (n.left != null)
          curLevel.add(n.left);
         if (n.right != null)
          curLevel.add(n.right);
      }
      res.add(l);
      level = curLevel;
    }
    return res;
  }
}
