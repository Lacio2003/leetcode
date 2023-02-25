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
    准备两个栈，对原来的树使用先序遍历，将结果存储到一个集合当中，然后对集合进行反转。

    时间复杂度:O(n)
    空间复杂度:O(n)
*/

class Solution {
    public List<Integer> postorder(Node root) {
        // 对原来的树进行先序遍历
        // 存储结果的栈
        Deque<Integer> second = new ArrayDeque();
        List<Integer> ans = new ArrayList<>();
        // 排除特殊情况ger> ans = new Arra
        if (null == root) {
            return ans; 
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 获取顶端节点
            Node node = stack.pop();
            second.push(node.val);
            // 获取孩子结点
            for (Node e : node.children) {
                stack.push(e);
            }
        }

        //将栈中的数据取出来
        while (!second.isEmpty()) {
            ans.add(second.pop());
        }

        return ans;
    }
}