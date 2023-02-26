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
    省掉集合，直接进行中序遍历的创建

    时间复杂度:O(n)
    空间复杂度:O(logn)
*/
class Solution {
    TreeNode dummy = new TreeNode();
    TreeNode pointer = dummy;
    public TreeNode increasingBST(TreeNode root) {
        // basic case
        if (null == root) {
            return dummy.right;
        }

        increasingBST(root.left);
        // 链接新的节点
        TreeNode right = root.right;
        root.left = root.right = null;
        pointer.right = root;
        pointer = pointer.right;

        increasingBST(right);

        return dummy.right;
    }
}