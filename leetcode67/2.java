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
    根据题意，在所有的遍历的方式当中，层次遍历是最合适的
    时间复杂度:O(2^n)，n是二叉树的深度
    空间复杂度：O(k)，那一层结点的个数最多
*/
class Solution {
    public TreeNode expandBinaryTree(TreeNode root) {
        // 排序不合法的情况
        if (null == root) {
            return null;
        }
        
        // 用于层次遍历的队列
        Deque<TreeNode> queue = new ArrayDeque<>(); 
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 获取左右子树
            TreeNode left = cur.left, right = cur.right;

            if (null != left) {
                queue.offer(left);
                // 插入灯饰
                TreeNode newNode = new TreeNode(-1, left, null);
                cur.left = newNode;
            }

            if (null != right) {
                queue.offer(right);
                // 插入灯饰
                TreeNode newNode = new TreeNode(-1, null, right);
                cur.right = newNode;
            }
        }

        return root;
    }
}