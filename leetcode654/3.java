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
    在上一个程序上进行优化。使用数组代替Deque
    单调栈
    栈顶元素:pop，当前元素cur
    1.如果pop < cur，说明pop是cur的左子树上的结点。所以cur.left = pop，pop出栈(因为左子树已经构建完成了，这个结点没有用了)。重复这个过程，因为我们不知道pop是不是左边最大的子树。
    2.如果pop > cur，说明这个结点一定是cur的右结点。所以，pop.right = cur，cur入栈。
    3.重复以上步骤，直到数组遍历完成。最后最大的元素一定在栈底。

    时间复杂度:O(n)
    空间复杂度:O(1)，数组的长度最大是1000。
*/
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 1.准备变量
        TreeNode[] stack = new TreeNode[1001];
        // 栈顶指针
        int index = -1;

        // 2.开始遍历过程
        for (int e : nums) {
            // 新生成结点
            TreeNode newNode = new TreeNode(e);

            // pop < cur
            while (index >= 0 && stack[index].val < e) {
                // cur.left = pop;
                newNode.left = stack[index];
                index--;
            }

            if (index >= 0) {
                // 程序可以执行到这里，pop > cur
                stack[index].right = newNode;
            }

            // 将结点入栈
            stack[++index] = newNode;
        }

        // 根节点一定在栈底
        return stack[0];
    }
}