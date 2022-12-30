class Solution {
    // 存储符合节点的加总的和
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 当前节点为空，不可以继续递归
        if (root == null) {
            return sum;
        }

        // 将符合节点的值加总
        sum += (root.val >= low && root.val <= high) ? root.val : 0;
        // 往左子树递归
        rangeSumBST(root.left, low, high);
        // 往右子树递归
        rangeSumBST(root.right, low, high);

        // 返回加总的和
        return sum;
    }
}