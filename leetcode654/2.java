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
    website:https://leetcode.cn/problems/maximum-binary-tree/solutions/1762400/zhua-wa-mou-si-by-muse-77-myd7/
    单调栈
    1.使用一个栈
    2.如果栈顶元素比当前元素大，那么栈顶.right=当前元素，当前元素入栈
    3.如果栈顶元素比当前元素小，那么栈顶元素出栈，当前元素.left = 栈顶元素，重复这个过程，直到栈为空，或者满足第二个条件
    4.重复以上过程

    时间复杂度:O(n)
    空间复杂度:O(n)
    比上一个程序更快，因为上一个程序在寻找最大值的地方浪费了许多的时间
*/
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 1.准备变量
        Deque<TreeNode> stack = new LinkedList<>();

        // 2.遍历数组构造二叉树
        for (int e : nums) {
            // 生成新的结点
            TreeNode newNode = new TreeNode(e);

            // top.val < e
            while (!stack.isEmpty() && stack.peek().val < e) {
                newNode.left = stack.peek();
                stack.pop();
            }

            // 程序来到这里，栈可能为空或者top.val > e
            // 栈为空的情况
            if (stack.isEmpty()) {
                stack.push(newNode);
                continue;
            }
            // 栈不为空，那么一定是top.val > e
            stack.peek().right = newNode;
            stack.push(newNode);
        }


        // 栈顶的结点就是头结点
        return stack.pollLast();
    }
}