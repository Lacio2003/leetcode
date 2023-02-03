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
    采用右根左的遍历方式，将结果累加到s当中，进行重新给结点赋值
    递归实现
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (null == root) {
            return root;
        }

        // 先遍历右子树，计算累加和
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        // 再遍历左子树
        convertBST(root.left);

        return root;
    }
}