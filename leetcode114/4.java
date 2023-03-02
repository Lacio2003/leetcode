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
    使用一种特殊的先序遍历

    时间复杂度:O(n)
    空间复杂度:O(logn)
*/
class Solution {
    public void flatten(TreeNode root) {
        // 排除特殊情况
        if (null == root) {
            return;
        }

        // 开始先序遍历
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode pre = new TreeNode();
        while (!stack.isEmpty()) {
            // 获取当前指针
            TreeNode cur = stack.pop();
            // 修改链接
            pre.right = cur;
            pre.left = null;
            pre = cur;
            // 压入左节点和右节点
            if (null != cur.right) {
                stack.push(cur.right);
            }

            if (null != cur.left) {
                stack.push(cur.left);
            }
        }
    }
}