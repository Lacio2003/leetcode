class Solution {
    public boolean evaluateTree(TreeNode root) {
        // 当前节点是叶子节点
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        // 获取左右孩子的值
        boolean leftValue = evaluateTree(root.left), rightValue = evaluateTree(root.right);
        // 根据当前节点的值返回结果
        return root.val == 2 ? leftValue || rightValue : leftValue && rightValue;
    }
}
