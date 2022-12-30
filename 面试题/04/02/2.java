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
  * 思路：利用递归解决这个问题。通过每次选择中间位置来创建根节点。以此进行递归。
  * 时间复杂度：O(n)
  * 空间复杂度：O(n)
  */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 运用递归的思想来创建平衡二叉树
     * @param nums 要遍历的数组
     * @param left 左边界
     * @param right 右边界
     * @return 平衡二叉树的根节点
     */
    private TreeNode helper(int[] nums, int left, int right) {
        // 遍历完成
        if (left > right) {
            return null;
        }

        // 每次在中间偏左和偏右的位置随机选取一个
        // int mid = (left + right + rand.nextInt(2)) >> 1;
        // 每次选择中间偏右的位置
        int mid = (left + right + 1) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        // 创建左子树
        root.left = helper(nums, left, mid - 1);
        // 创建右子树
        root.right = helper(nums, mid + 1, right);

        return root;
    }
}