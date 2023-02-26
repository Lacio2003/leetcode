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
    先中序遍历存储到一个集合当中，然后构建二叉树

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        // 中序遍历将所有的节点放入到一个集合当中。
        List<TreeNode> nodes = new ArrayList<>();
        inOrder(nodes, root);

        // 构建二叉树
        TreeNode dummy = new TreeNode(), cur = dummy;
        for (int i = 0; i < nodes.size(); i++) {
            // 获取当前节点
            TreeNode node = nodes.get(i);
            // 将左右指针清空
            node.left = node.right = null;
            cur.right = node;
            cur = cur.right;
        }

        return dummy.right;
    }

    // 中序遍历二叉树
    private void inOrder(List<TreeNode> list, TreeNode root) {
        if (null == root) {
            return;
        }

        inOrder(list, root.left);
        list.add(root);
        inOrder(list, root.right);
    }
}