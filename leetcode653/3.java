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
    因为是二叉搜索树，使用中序遍历，可以得到一个升序序列，将这个序列存储当中
    然后使用双指针来遍历这个序列得到具体的和
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // 中序遍历，得到的序列存放在数组当中
        // 准备容器
        List<Integer> inOrderList = new ArrayList<>();
        // 开始遍历
        inOrder(root, inOrderList);

        // 双指针方法遍历序列
        int left = 0, right = inOrderList.size() - 1;

        while (left < right) {
            if (inOrderList.get(left) + inOrderList.get(right) == k) {
                return true;
            }

            if (inOrderList.get(left) + inOrderList.get(right) > k) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}