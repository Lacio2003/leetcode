/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/*
    递归遍历，先遍历孩子节点，然后遍历根节点

    时间复杂度:O(n)
    空间复杂度:O(logn)
*/
class Solution {
    public List<Integer> postorder(Node root) {
        postOrderTraversal(root);
        return ans;
    }

    // 存储节点的值
    List<Integer> ans = new ArrayList<>();
    private void postOrderTraversal(Node root) {
        // basic case
        if (null == root) {
            return;
        }

        // 遍历子节点
        int size = root.children.size();
        for (int i = 0; i < size; i++) {
            postOrderTraversal(root.children.get(i));
        }

        ans.add(root.val);
    }
}