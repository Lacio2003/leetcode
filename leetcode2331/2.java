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

/*
    在1的基础上简化代码
*/
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (null == root.left) {
            return root.val == 1;
        }

        boolean leftValue = evaluateTree(root.left), rightValue = evaluateTree(root.right);
        return root.val == 2 ? leftValue || rightValue : leftValue && rightValue;
    }
}