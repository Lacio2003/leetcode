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
    根据题意可以得到，如果一个结点有子节点，那么就插入一个灯饰。
    递归解法，检查左子树是否为空，不为空插入一个灯饰，右子树同样如此。
    时间复杂度:O(2^n)，n是二叉树的深度
    空间复杂度:O(n)
*/
class Solution {
    public TreeNode expandBinaryTree(TreeNode root) {
        // basic case
        if (null == root) {
            return null;
        }

        // 检查左子树
        TreeNode left = expandBinaryTree(root.left);
        if (null != left) {
            // 左子树不是空，插入节点
            TreeNode decorate = new TreeNode(-1, root.left, null);
            root.left = decorate;
        }
        // 检查右子树
        TreeNode right = expandBinaryTree(root.right);
        if (null != right) {
            TreeNode decorate = new TreeNode(-1, null, root.right);
            root.right = decorate;
        }

        return root;
    }
}