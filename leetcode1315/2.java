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
    在1的基础上进行代码的优化
*/
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        dfs(1, 1, root);
        return ans;
    }

    int ans = 0;
    private void dfs(int grandValue, int parentValue, TreeNode root) {
        if (null == root) {
            return;
        }

        // 祖父节点是偶数
        if ((grandValue & 1) == 0) {
            ans += root.val;
        }

        dfs(parentValue, root.val, root.left);
        dfs(parentValue, root.val, root.right);
    }
}