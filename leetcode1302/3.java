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
    广度优先搜索遍历，使用哈希表记录每一个层的结点的值的和。
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        // 1.准备变量
        // 存储每一层的结点的和的哈希表
        Map<Integer, Integer> hash = new HashMap<>();
        // 层序遍历的队列
        Deque<TreeNode> queue = new ArrayDeque<>();
        // 记录层数的变量
        int level = 1;

        // 2.开始层序遍历
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size --> 0) {
                // 获取结点
                TreeNode cur = queue.poll();
                // 计算当前层数的和
                hash.put(level, hash.getOrDefault(level, 0) + cur.val);
                // 压入左右子树
                if (null != cur.left) queue.add(cur.left);
                if (null != cur.right) queue.add(cur.right);
            }
            // 更新深度
            level++;
        }

        return hash.get(level - 1);
    }
}