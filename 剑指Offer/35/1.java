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
 *  准备一个哈希表，key是老的节点，value是新的节点
 *  遍历第一个链表，在遍历每一个节点的过程中，生成一个新的节点，将老的节点作为key存储放哈希表当中，新的节点作为对应的value
 * 在遍历一次旧的链表，设置每一个新节点的next和random指针。可以根据老的节点的指针指向的节点在哈希表当中获取对应的新节点。
 * 最后，返回新节点的头
 * 
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
class Solution {
    public Node copyRandomList(Node head) {
        // 1.准备一个哈希表
        Map<Node, Node> hash = new HashMap<>();

        // 2.遍历旧的链表，生成新的节点并放入哈希表当中
        for (Node p = head; p != null; p = p.next) {
            hash.put(p, new Node(p.val));
        }

        // 3.遍历一次旧的链表，设置新节点的指针
        for (Node p = head; p != null; p = p.next) {
            Node newNode = hash.get(p);
            // 设置next指针
            newNode.next = hash.get(p.next);
            // 设置random指针
            newNode.random = hash.get(p.random);
        }

        // 4.返回新链表的头
        return hash.get(head);
    }
}