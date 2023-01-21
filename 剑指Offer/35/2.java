/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/**
 * 思路:
 *  1.遍历一遍老链表，然后生成对应的新节点，并将新节点插入到对应的老节点的后面。
 *  2.根据老节点设置random指针。因为新节点就在原来老节点的后面，所以，设置random节点非常容易
 *  3.遍历一遍老链表，将新节点和旧节点分离。
 */
class Solution {
    public Node copyRandomList(Node head) {
        // 排序不合法的情况
        if (null == head) {
            return null;
        }
            

        // 1.遍历一遍老链表，生成对应的新节点，并将新节点插入到对应的老节点的后面
        for (Node p = head; p != null; p = p.next.next) {
            // 生成新节点
            Node newNode = new Node(p.val);
            // 插入到老节点的后面
            newNode.next = p.next;
            p.next = newNode;
        }

        // 2.设置random指针
        for (Node p = head; p != null; p = p.next.next) {
            Node newNode = p.next;
            newNode.random = null == p.random ? null : p.random.next;
        }

        // 3.分离新旧节点
        // newHead是新链表的头部，为了方便操作，设置一个头节点。
        // curNode 是当前节点
        Node newHead = new Node(0), curNode = newHead;
        for (Node p = head; p != null; p = p.next) {
            Node newNode = p.next;
            // 断开新节点和旧节点之间的连接
            p.next = newNode.next;
            // 将节点插入到新的链表当中
            curNode.next = newNode;
            curNode = newNode;
        }

        return newHead.next;
    }
}