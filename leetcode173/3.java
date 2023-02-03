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
    使用Morris中序遍历。

    当前结点没有左子树，直接向右移动。
    当前结点有左节点，找到左子树的最右边的结点
        如果最右边的结点的右指针为null，那么将右指针指向当前节点，指针向左移动
        如果最右边的结点的右指针不为空，那么将右指针置空，打印结点，指针向右移动。
    
    时间复杂度:O(n)，每一次操作平摊下来是O(1)
    空间复杂度:O(1)
*/
class BSTIterator {
    // 指向结点的指针
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        cur = root;
    }
    
    public int next() {
        while (null != cur && null != cur.left) {
            // 寻找左子树的最右边的结点
            TreeNode rightestNode = cur.left;
            while (null != rightestNode.right && cur != rightestNode.right) {
                rightestNode = rightestNode.right;
            }

            if (null == rightestNode.right) {
                // 当前节点的左子树没有遍历
                rightestNode.right = cur;
                cur = cur.left;
                continue;
            }
            // 左子树已经遍历完成
            rightestNode.right = null;
            break;
        }

        int value = cur.val;
        cur = cur.right;
        return value;
    }
    
    public boolean hasNext() {
        return null != cur;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */