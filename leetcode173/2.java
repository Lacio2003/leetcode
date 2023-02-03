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
    使用非递归遍历，使用一个集合来维护栈，这样每次只遍历一个高度。
    时间复杂度:O(n)，平摊下来每一次操作的时间复杂度是O(1)
    空间复杂度:O(h)，h是树的高度
*/
class BSTIterator {
    // 指向结点的指针
    TreeNode cur;
    // 中序遍历使用的栈
    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        // 初始化变量
        cur = root;
        stack = new LinkedList<>();
    }
    
    public int next() {
        // 每次只遍历一个高度
        while (null != cur) {
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();
        int value = cur.val;
        cur = cur.right;
        return value;
    }
    
    public boolean hasNext() {
        return null != cur || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */