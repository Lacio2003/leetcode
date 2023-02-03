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
    同时遍历两个链表，original遇到target的时候，返回cloned对应的结点
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(original, cloned, target);
        return res;
    }

    TreeNode res;
    private void dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        if (null == original) {
            return;
        }

        if (original == target) {
            res = cloned;
        }

        dfs(original.left, cloned.left, target);
        dfs(original.right, cloned.right, target);
    }
}