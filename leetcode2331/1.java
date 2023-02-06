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
    递归实现后序遍历，先获取两个结点的布尔值，然后使用父节点的操作符进行运算
    时间复杂度:O(n)
    空间复杂度:O(logn)
*/
class Solution {
    public boolean evaluateTree(TreeNode root) {
        // basic case
        if (null == root.left && null == root.right) {
            return root.val == 0 ? false : true;
        }

        // 获取左右子树的值
        boolean leftVal = evaluateTree(root.left);
        boolean rightVal = evaluateTree(root.right);

        return root.val == 2 ? leftVal | rightVal : leftVal && rightVal;
    }
}