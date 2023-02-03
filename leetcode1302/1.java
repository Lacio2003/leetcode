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
    1.使用一个变量来记录层数的和，使用一个变量来最大的层数。
    2.层序遍历，使用哈希表将记录所有结点的层数。
    时间复杂度:O(2^n)，n是二叉树的深度
    空间复杂度:O(2^n)
*/
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        // 1.准备各种变量

        // 层序遍历需要的队列
        Deque<TreeNode> queue = new ArrayDeque<>();
        // 记录每一个结点的层数的哈希表
        Map<TreeNode, Integer> hash = new HashMap<>();
        // 记录层数
        int level = 1;
        // 记录每一个层的和
        int sum = 0;

        // 2.开始层序遍历
        queue.offer(root);
        hash.put(root, 1);
        while (!queue.isEmpty()) {
            // 1.取出结点
            TreeNode cur = queue.poll();
            // 2.更新sum和level
            if (hash.get(cur) == level) {
                // 还在一层
                sum += cur.val;
            } else {
                // 进入了下一层
                level++;
                sum = cur.val;
            }
            // 3.压入左右子树
            if (null != cur.left) {
                queue.offer(cur.left);
                // 设置层数
                hash.put(cur.left, level + 1);
            }
            
            if (null != cur.right) {
                queue.offer(cur.right);
                // 设置层数
                hash.put(cur.right, level + 1);
            }
        }

        return sum;
    }
}