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
    上一个的非递归实现
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // 1.准备变量
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode res = cloned;

        // 2.开始遍历
        TreeNode cur = cloned;
        while (null != cur || !stack.isEmpty()) {
            while (null != cur) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (cur.val == target.val) {
                res = cur;
                break;
            }

            cur = cur.right;
        }

        return res;
    }
}