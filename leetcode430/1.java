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
    思路:
        1.如果head.child为空，指针直接向下移动
        2.如果指针head.chile不为空，使用flatten获取头节点，然后插入节点
    时间复杂度:O(n^2)
    空间复杂度:O(n)
 */
class Solution {
    public Node flatten(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        while (null != head) {
            if (null == head.child) {
                // 孩子指针为空
                head = head.next;
            } else {
                Node tmp = head.next;
                // 获取要插入链表的头节点
                Node chead = flatten(head.child);
                // 插入头节点
                head.next = chead;
                chead.prev = head;
                // 获取要插入链表的尾节点
                while (null != chead.next) {
                    chead = chead.next;
                }

                // 插入尾节点
                chead.next = tmp;
                if (null != tmp) {
                    tmp.prev = chead;
                }

                head.child = null;
                head = tmp;
            }
        }

        return dummy.next;
    }
}