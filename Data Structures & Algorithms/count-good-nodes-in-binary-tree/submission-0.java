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
  public int goodNodes(TreeNode root, int x) {
    if (root == null)
      return 0;
    return (root.val >= x ? 1 : 0) + goodNodes(root.left, Math.max(root.val, x))
        + goodNodes(root.right, Math.max(root.val, x));
  }

  public int goodNodes(TreeNode root) {
    return goodNodes(root, Integer.MIN_VALUE);
  }
}
