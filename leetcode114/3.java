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
    假设当前结点是cur
    将cur的右子树链接到cur的左子树的最右边的结点
    将cur的左子树变成cur的右子树
    cur.left = null
    考虑下一个结点:root = root.right

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public void flatten(TreeNode root) {
        while (null != root) {
            if (null != root.left) {
                // 寻找左子树最右边的结点
                TreeNode rightest = root.left;
                while (null != rightest.right) {
                    rightest = rightest.right;
                }

                // 将右子树连接到左子树的最右边的结点
                rightest.right = root.right;
                // 将左子树变成root.right
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }
}