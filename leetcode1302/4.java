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
    深度优先遍历，使用一个哈希表和一个变量来记录层数
    使用递归来对哈希表进行填充
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    // 存储每一个层的和的哈希表
    Map<Integer, Integer> hash = new HashMap<>();
    public int deepestLeavesSum(TreeNode root) {
        int depth = dfs(root, 1);
        return hash.get(depth - 1);
    }

    
    private int dfs(TreeNode root, int level) {
        // basic case
        if (null == root) {
            return level;
        }

        // 将值压入哈希表
        hash.put(level, hash.getOrDefault(level, 0) + root.val);

        // 重复这个过程
        int leftLevel = dfs(root.left, level + 1);
        int rightLevel = dfs(root.right, level + 1);
        return Math.max(leftLevel, rightLevel);
    }
}