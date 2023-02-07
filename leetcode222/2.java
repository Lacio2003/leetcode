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
    层序遍历，如果有左右子树其中一个为空，那么直接停止就可以了。
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int countNodes(TreeNode root) {
        // 排除不合法的情况
        if (null == root) {
            return 0;
        }
        // 准备变量
        // 存储结点的数量
        int ans = 0;
        // 层序遍历需要的队列
        Deque<TreeNode> queue = new ArrayDeque<>();

        // 层序遍历
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 遍历这一层的结点
            for (int i = queue.size(); i > 0; i--) {
                // 获取结点
                TreeNode cur = queue.poll();
                // 更新ans
                ans++;
                // 压入结点的左右子树
                if (null != cur.left) {
                    queue.offer(cur.left);
                } else {
                    break;
                }

                if (null != cur.right) {
                    queue.offer(cur.right);
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}