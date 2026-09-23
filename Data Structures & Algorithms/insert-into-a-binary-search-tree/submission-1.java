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
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root==null){
        return new TreeNode(val);
    }
    TreeNode cur = root;

    while (cur.val > val && cur.left != null || cur.val <= val && cur.right != null) {
      if (cur.val > val)
        cur = cur.left;
      else if (cur.val <= val)
        cur = cur.right;
    }
    TreeNode node = new TreeNode(val);
    if (cur.val > val)
      cur.left = node;
    else if (cur.val <= val)
      cur.right = node;
    return root;
  }
}