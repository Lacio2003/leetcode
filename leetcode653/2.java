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
    广度遍历搜索+哈希表
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // 1.准备容器
        Deque<TreeNode> queue = new ArrayDeque<>();
        Set<Integer> hash = new HashSet<>();

        // 2.开始遍历
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 获取当前结点
            TreeNode cur = queue.poll();

            // 查看哈希表是否存在k-val
            if (hash.contains(k - cur.val)) {
                return true;
            }
            hash.add(cur.val);
            // 加入左右子树
            if (null != cur.left) {
                queue.offer(cur.left);
            }

            if (null != cur.right) {
                queue.offer(cur.right);
            }
        }

        return false;
    }
}