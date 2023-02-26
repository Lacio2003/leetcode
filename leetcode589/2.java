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
    准备一个栈，遍历节点，如果这个节点不是空，将这个节点加入答案，然后将他的孩子压栈，反复如此

    时间复杂度:O(n)
    空间复杂度:O(logn)
*/
class Solution {
    public List<Integer> preorder(Node root) {
        // 准备变量
        List<Integer> ans = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();

        // 开始遍历
        if (null == root) {
            return ans;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            // 得到节点
            Node cur = stack.pop();
            // 将这个节点加入答案
            ans.add(cur.val);
            // 加入子节点
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
        }

        return ans;
    }
}