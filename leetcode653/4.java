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
    直接在二叉树上操作双指针
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // 准备变量
        TreeNode left = root, right = root;
        Deque<TreeNode> leftStack = new ArrayDeque(), rightStack = new ArrayDeque(); 

        // 把左指针和右指针移动到树的最左边和最右边
        while (null != left.left) {
            leftStack.push(left);
            left = left.left;
        }
        leftStack.push(left);
        while (null != right.right) {
            rightStack.push(right);
            right = right.right;
        }
        rightStack.push(right);

        // 遍历二叉树，根据两个指针的和进行指针的移动
        while (left != right) {

            if (left.val + right.val == k) {
                return true;
            }

            // 移动指针
            if (left.val + right.val < k) {
                // 将left向右移动
                left = moveLeft(leftStack);
            } else {
                // 将right向左移动
                right = moveRight(rightStack);
            }
        }

        return false;
    }

    private TreeNode moveRight(Deque<TreeNode> stack) {
        TreeNode root = stack.pop(), node = root.left;
        // 获取左子树最右边的结点
        while (null != node) {
            stack.push(node);
            node = node.right;
        }

        return root;
    }

    private TreeNode moveLeft(Deque<TreeNode> stack) {
        TreeNode root = stack.pop(), node = root.right;
        // 获取右子树最左边的结点
        while (null != node) {
            stack.push(node);
            node = node.left;
        }
    
        return root;
    }
}