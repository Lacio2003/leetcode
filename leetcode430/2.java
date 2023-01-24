/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

/*
    在上一个的递归的基础上进行优化。上一个递归每次都需要寻找子链表的尾节点。导致深度越深的节点比访问的次数增多。所以，非常慢。
    我们可以单独写一个递归，让他返回尾节点，这样就可以避免这样的情况。
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node head) {
        Node last = head;
        while (null != head) {
            if (null == head.child) {
                last = head;
                head = head.next;
            } else {
                Node temp = head.next;
                // 获取要插入的链表的尾节点
                Node childLast = dfs(head.child);
                // 获取要插入的链表的头节点
                Node chead = head.child;
                // 插入头节点
                chead.prev = head;
                head.next = chead;
                head.child = null;

                // 插入尾节点
                if (null != childLast) {
                    childLast.next = temp;
                }
                if (null != temp) {
                    temp.prev = childLast;
                }

                last = head;
                head = childLast;
            }
        }

        return last;
    }
}