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
    广度优先搜索遍历，寻找值为偶数的结点，计算它们的子孙结点
    时间复杂度：O(n)
    空间复杂度：O(n)
*/
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        // 1.准备变量
        // 存储最后的答案
        int ans = 0;
        // 层次遍历需要的队列
        Deque<TreeNode> queue = new ArrayDeque<>();

        // 2.开始层序遍历
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 弹出结点
            TreeNode cur = queue.poll();
            // 确定结点的值
            if ((cur.val & 1) == 0) {
                // 计算子孙节点
                if (null != cur.left) {
                    ans += null != cur.left.left ? cur.left.left.val : 0;
                    ans += null != cur.left.right ? cur.left.right.val : 0;
                }

                if (null != cur.right) {
                    ans += null != cur.right.left ? cur.right.left.val : 0;
                    ans += null != cur.right.right ? cur.right.right.val : 0;
                }
            }
            
            // 加入左右结点
            if (null != cur.left) {
                queue.offer(cur.left);
            }

            if (null != cur.right) {
                queue.offer(cur.right);
            }
        }

        return ans;
    }
}