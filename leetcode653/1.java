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
    使用哈希表，深度优先遍历，如果哈希表当中存在k-val，那么返回true，否则就是false
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    Set<Integer> hash = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (null == root) {
            return false;
        }

        if (hash.contains(k - root.val)) {
            return true;
        }

        hash.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }


}