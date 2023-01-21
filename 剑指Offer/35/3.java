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

/* 
 * 思路:将这个链表看成一张图，利用深度优先搜索进行拷贝。
 *   递归的结束条件:如果当前节点为空直接返回null，如果当前节点，拷贝过，返回对应的新节点
 *   递归的过程:当前节点如果拷贝过，返回对应的新节点，如果没有拷贝过，进行拷贝。然后递归拷贝这个节点的next指针和random指针
 *   递归的参数:一个Node指针
 *
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
*/
class Solution {
    Map<Node, Node> hash = new HashMap<>();
    public Node copyRandomList(Node head) {
        // 节点为空，直接返回null
        if (null == head) {
            return null;
        }
        // 当前节点拷贝过，返回对应的新节点
        if (hash.containsKey(head)) {
            return hash.get(head);
        }

        // 当前节点没有拷贝过，进行拷贝
        Node newNode = new Node(head.val);
        // 这句话不要放在下面，不然会死循环
        hash.put(head, newNode);

        // 拷贝next指针和random指针
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);

        return newNode;
    }
}