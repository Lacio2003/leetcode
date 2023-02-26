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
    使用Morris遍历
    假设当前节点是cur
    如果cur没有左子树，那么cur = cur.right
    如果cur有左子树，那么找到左子树最右边的节点，  
        如果最右边的节点的右指针不为空，那么cur = cur.right，然后将最右边节点的右指针置空
        如果最右边的节点的右指针为空，那么最右边节点的右指针指向cur，然后cur = cur.left

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        // 为了方便操作，建立虚拟节点 
        TreeNode dummy = new TreeNode(), p = dummy;

        // Mirror遍历
        TreeNode cur = root;
        while (null != cur) {
            if (null != cur.left) {
                // 找到左子树最右边的节点
                TreeNode rightest = cur.left;
                while (cur != rightest.right && null != rightest.right) {
                    rightest = rightest.right;
                }

                // 对最右边的节点进行判断
                if (null == rightest.right) {
                    // 如果最右边的节点的右指针为空，
                    // 那么最右边节点的右指针指向cur，然后cur = cur.left
                    rightest.right = cur;
                    cur = cur.left;
                    continue;
                } 
                // 如果最右边的节点的右指针为空，
                // 那么最右边节点的右指针指向cur，然后cur = cur.left
                cur.left = null;
            }

            // 链接结点
            p.right = cur;
            p = cur;
            cur = cur.right;
        }

        return dummy.right;
    }
}