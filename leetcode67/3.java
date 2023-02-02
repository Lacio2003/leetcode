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
    递归的升级版本，将代码进一步简化
*/
class Solution {
    public TreeNode expandBinaryTree(TreeNode root) {
        // basic case
        if (null == root) {
            return null;
        }

        if (null != root.left) {
            // 建立灯饰
            root.left = new TreeNode(-1, expandBinaryTree(root.left), null);
        }

        if (null != root.right) {
            // 建立灯饰
            root.right = new TreeNode(-1, null, expandBinaryTree(root.right));
        }

        return root;
    }
}