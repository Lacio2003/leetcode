/*
    思路：利用二叉搜索树的(左子树比根节点小，右节点比根节点大)特性，来缩小搜索的范围。
*/
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 当前节点为空，直接返回0
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            // 当前节点的值比low小，说明符合的节点一定在右子树上
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            // 当前节点的值比high大，说明符合节点一定在左子树上
            return rangeSumBST(root.left, low, high);
        }

        // 因为节点不符合的情况都已经被我们排除了，所以直接进行加总就可以了
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}