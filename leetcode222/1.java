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
    直接遍历二叉树统计结点
    时间复杂度:O(n)
    空间复杂度:O(logn)
*/
class Solution {
    public int countNodes(TreeNode root) {
        if (null == root) {
            return 0;
        }

        // 统计整棵树的结点的个数
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}