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
    将所有的结点放入到一个list当中，然后建造二叉树。

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public void flatten(TreeNode root) {
        // 将所有的结点放入到list当中。
        List<TreeNode> list = new ArrayList<>();
        preTraversal(root, list);

        // 构造二叉树
        TreeNode dummy = new TreeNode(), tail = dummy;
        for (TreeNode e : list) {
            e.left = e.right = null;
            tail.right = e;
            tail = tail.right;
        }

        root = dummy.right;
    }

    private void preTraversal(TreeNode root, List<TreeNode> list) {
        if (null == root) {
            return;
        }

        list.add(root);
        preTraversal(root.left, list);
        preTraversal(root.right, list);
    }
}