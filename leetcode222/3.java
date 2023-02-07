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
    根据完全二叉树的性质，
        左右子树的高度相等，那么左子树一定是满二叉树。
        左右子树的高度不相等，那么右子树一定是满二叉树
    时间复杂度:O(logn * logn)
    空间复杂度:O(logn)
*/
class Solution {
    public int countNodes(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftDepth = countDepth(root.left), rightDepth = countDepth(root.right);
        if (leftDepth == rightDepth) {
            // 左右高度相等，那么左子树一定是满的
            return countNodes(root.right) + (1 << leftDepth);
        } else {
            // 左右高度不相等，那么右子树一定是满的
            return countNodes(root.left) + (1 << rightDepth);
        }
    }

    private int countDepth(TreeNode root) {
        int level = 0;
        while (null != root) {
            level++;
            root = root.left;
        }

        return level;
    }
}