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
    使用一个list集合先把树中序遍历拿出来，然后使用list集合作为返回。
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class BSTIterator {
    
    // 存储树的所有结点
    List<Integer> list = new ArrayList<>();
    // next指针
    int pointer;

    public BSTIterator(TreeNode root) {
        // 中序遍历将树的结点取出来
        inOrderTraversal(root);
    }
    
    public int next() {
        return list.get(pointer++);
    }
    
    public boolean hasNext() {
        return pointer < list.size();
    }

    // 中序遍历，先把树中所有的结点取出来
    private void inOrderTraversal(TreeNode root) {
        // basic case
        if (null == root) {
            return;
        }

        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */