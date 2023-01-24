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
        1.遍历链表。如果child不为空，那么获取这一段链表，并接入。
        2.让指针向下移动一个即可
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public Node flatten(Node head) {
        // 为了方便处理，设置一个哑节点
        Node dummy = new Node(0);
        dummy.next = head;

        for (; null != head; head = head.next) {
            if (null != head.child) {
                Node temp = head.next;
                Node chead = head.child;
                // 插入头节点
                head.next = chead;
                chead.prev = head;
                head.child = null;
                // 获取尾节点
                Node last = chead;
                while (null != last.next) {
                    last = last.next;
                }

                // 插入尾节点
                last.next = temp;
                if (null != temp) {
                    temp.prev = last;
                }
            }
        }

        return dummy.next;
    }
}