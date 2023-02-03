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
    使用Morris向右遍历
    如果当前结点没有右子树，直接向左移动
    如果当前结点右右子树，那么寻找右子树的最左边的结点，
        如果最左边的结点的左指针为空，那么指向当前结点
        如果最左边的结点的左指针不为空，那么置空，自己向左移动。
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public TreeNode convertBST(TreeNode root) {
        // 1.准备变量
        TreeNode cur = root;
        int sum = 0;
        // 2.开始mirror遍历
        while (null != cur) {
            // 右子树不为空
            if (null != cur.right) {
                // 寻找右子树最左边的结点
                TreeNode leftestNode = cur.right;
                while (null != leftestNode.left && cur != leftestNode.left) {
                    leftestNode = leftestNode.left;
                }

                // 判断最左边结点的左指针
                if (null == leftestNode.left) {
                    leftestNode.left = cur;
                    cur = cur.right;
                    continue;
                } 
                // 右子树已经遍历完成
                leftestNode.left = null;
            }
            sum += cur.val;
            cur.val = sum;
            // 右子树为空的情况以及最左边结点的左指针不为空的情况
            cur = cur.left;
        }

        return root;
    }
}