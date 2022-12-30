/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**
  * 思路：通过递归创建平衡二叉树，每次选择中间位置作为根节点
  * 时间复杂度：O(n)
  * 空间复杂度：O(1)
  */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 递归创建平衡二叉树
     * @param nums 提供节点的数组
     * @param left 左边界
     * @param right 右边界
     * @return 平衡二叉树的根节点
     */
    private TreeNode helper(int[] nums, int left, int right) {
        // 遍历完成或者数组为空
        if (left > right) {
            return null;
        }

        // 每次选取中间偏左边的位置
        int mid = (left + right) >> 1;
        // 创建当前子树的根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 创建左子树
        root.left = helper(nums, left, mid - 1);
        // 创建右子树
        root.right = helper(nums, mid + 1, right);

        return root;
    }
}