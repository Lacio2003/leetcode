/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
    因为题目说书中的结点的值不相同，那么直接对clone进行搜索即可。
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(cloned, target);
        return res;
    }

    // 记录最后的答案
    TreeNode res;
    private void dfs(TreeNode root, TreeNode target) {
        // basic case
        if (null == root) {
            return;
        }

        // 找出target结点
        if (root.val == target.val) {
            res = root;
            return;
        }

        dfs(root.left, target);
        dfs(root.right, target);
    }
}