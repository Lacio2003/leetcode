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
    问题里面又嵌套一个问题，非常明显，属于一个二叉树的dp问题。可以从子节点上获取我们想要的值来解决这个问题
    定义一个类，这个类包括:子树的结点的数量，子树的和，后序遍历进行递归。
    时间复杂度:O(n)
    空间复杂度:O(logn)
*/
class Solution {
	// 你可以不写这个类，使用一个数组进行代替
    private class RetValue {
        int sum;
        int count;

        public RetValue(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    // 存储最后的答案
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        postorderTraversal(root);
        return ans;
    }

    private RetValue postorderTraversal(TreeNode root) {
        if (null == root) {
            return new RetValue(0, 0); 
        }
        
        //  获取左右子树的值
        RetValue left = postorderTraversal(root.left);
        RetValue right = postorderTraversal(root.right);

        // 计算子树的和以及子树的结点的数量
        int curSum = left.sum + right.sum + root.val, curCount = left.count + right.count + 1; 
        if (curSum / curCount == root.val) {
            ans++;
        }

        return new RetValue(curSum, curCount);
    }
}