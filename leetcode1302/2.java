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
   
    在1的基础进行了优化，去掉哈希表
    时间复杂度:O(2^n)，n是二叉树的深度
    空间复杂度:O(2^n)
*/
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        // 1.准备各种变量

        // 层序遍历需要的队列
        Deque<TreeNode> queue = new ArrayDeque<>();
        // 当前层的最后一个结点
        TreeNode curLast = root;
        // 下一层的最后一个结点
        TreeNode nextLast = null;
        // 记录每一个层的和
        int curSum = 0;
        // 记录上一层的和
        int preSum = 0;

        // 2.开始层序遍历
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 1.取出结点
            TreeNode cur = queue.poll();

            // 2.压入左右子树并更新nextLast
            if (null != cur.left) {
                queue.offer(cur.left);
                nextLast = cur.left;
            }
            
            if (null != cur.right) {
                queue.offer(cur.right);
                nextLast = cur.right;
            }

            // 3.更新sum和level
            if (cur == curLast) {
                // 进入下一层
                curLast = nextLast;
                nextLast = null;
                preSum = curSum + cur.val;
                curSum = 0;
            } else {
                // 还在当前层
                curSum += cur.val;
            }
        }

        return preSum;
    }
}