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
  public boolean isValidBST(TreeNode root, int min, int max) {
    if (root == null || (root.left == null && root.right == null))
      return true;
    // System.out.println(root.val + " " + min + " " + max);
    if ((root.val > max || root.val < min)
        || (root.left != null
            && (root.left.val >= root.val || root.left.val >= max || root.left.val <= min))
        || (root.right != null
            && (root.val >= root.right.val || root.right.val >= max || root.right.val <= min)))
      return false;

    return isValidBST(root.left, min, Math.min(root.val, max))
        && isValidBST(root.right, Math.max(root.val, min), max);
  }

  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}
