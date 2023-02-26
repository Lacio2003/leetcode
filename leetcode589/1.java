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
    递归遍历

    时间复杂度:O(n)
    空间复杂度:O(logn)
*/
class Solution {
    // 存储最后的答案
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        // basic case
        if (null == root) {
            return ans;
        }

        // 先遍历根节点，然后是孩子
        ans.add(root.val);
        for (Node e : root.children) {
            preorder(e);
        }

        return ans;
    }
}