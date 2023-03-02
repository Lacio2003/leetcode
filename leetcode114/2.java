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
    直接使用递归进行赋值

    时间复杂度:O(n)
    空间复杂度:O(logn)
*/
class Solution {
    TreeNode dummy = new TreeNode();
    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }

        // 保存指针
        TreeNode left = root.left, right = root.right;
        
        // 链接结点
        root.left = root.right = null;
        dummy.right = root;
        dummy = dummy.right;

        // 进行递归
        flatten(left);
        flatten(right);

        root = dummy.right;
    }
}