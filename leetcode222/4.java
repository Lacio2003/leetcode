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
    根据完全二叉树的性质，使用二分法查找。
    时间复杂度:O(logn * logn)
    空间复杂度:O(1)
*/
class Solution {
    public int countNodes(TreeNode root) {
        // 排除不合法的情况
        if (null == root) {
            return 0;
        }
        // 获取二叉树的高度
        int depth = countDepth(root);
        // 进行二分法查找
        int low = 1 << depth, high = (1 << (depth + 1)) - 1;
        while (low < high) {
            int mid = low + ((high - low + 1) >> 1);
            if (exist(root, depth, mid)) {
                // mid结点存在，说明结点的数量>=mid
                low = mid;
            } else {
                // mid结点不存在，结点的数量一定小于mid
                high = mid - 1;
            }
        }

        return low;
    }

    /**
     * 计算二叉树的层数，从0层开始计算。
     * 
     * @param root 二叉树的根节点
     * @return 返回二叉树的层数
     */
    private int countDepth(TreeNode root) {
        int level = 0;
        while (null != root.left) {
            level++;
            root = root.left;
        }

        return level;
    }

    /**
     * 判断完美二叉树中一个结点是不是存在。
     * 
     * @param root 二叉树的根节点
     * @param level 二叉树的层数
     * @param k 要判断的结点在完美二叉树中的编号
     * @return 改结点是不是存在
     */
    private boolean exist(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        while (null != root && bits > 0) {
            if ((bits & k) == 0) {
                root = root.left;
            } else {
                root = root.right;
            }

            bits >>= 1;
        }

        return null != root;
    }
}