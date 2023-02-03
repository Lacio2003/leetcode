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
    中序遍历，先遍历一遍，将所有的值放入一个list集合当中。因为是二叉搜索树，所以，中序遍历是一个升序的集合。并且利用list构建出前缀和。
    再次遍历一遍，将对应的结点的值进行修改。
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public TreeNode convertBST(TreeNode root) {
        // 1.准备变量
        List<Integer> list = new ArrayList<>();

        // 2.中序遍历，填充list集合
        inOrderTraversal(list, root);

        // 3.利用list集合构建前缀和数组
        int len = list.size();
        // 为了方便操作，将长度加1
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = list.get(len - i) + preSum[i - 1];
        }

        // 4.再次中序遍历，修改原来的结点
        index = len + 1;
        fill(preSum, root);
        return root;
    }

    private void inOrderTraversal(List<Integer> list, TreeNode root) {
        if (null == root) {
            return;
        }

        inOrderTraversal(list, root.left);
        list.add(root.val);
        inOrderTraversal(list, root.right);
    }

    int index;
    private void fill(int[] preSum, TreeNode root) {
        if (null == root) {
            return;
        }

        fill(preSum, root.left);
        index--;
        root.val = preSum[index];
        fill(preSum, root.right);
    }
}