/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

/*
    思路:
        1.提前创建好节点
        2.判断head是否为空，如果为空直接返回创建好的insertVal节点
        3.寻找链表当中的最大值和最小值
        4.如果最小值等于最大值，那么节点插入到哪一个位置都可以
        5.如果insertVal >= max || insertVal <= min，那么插入到(下一个节点当前节点的地方)
        6.如果min < insertVal && insertVal < max，那么寻找(cur.val <= x && cur.next.val >= x)
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        // 1.提前创建好节点
        Node insertNode = new Node(insertVal);
        insertNode.next = insertNode;

        // 2.判断head是否为空
        if (null == head) {
            return insertNode;
        }

        // 3.寻找链表当中的最大值和最小值
        Node p = head.next;
        Node min = head, max = head;
        while (head != p) {
            min = min.val < p.val ? min : p;
            max = max.val > p.val ? max : p;
            p = p.next;
        }

        // 默认最大值等于最小值
        Node position = head;

        // 4.对最大值和最小值进行判断
         if (insertVal <= min.val || insertVal >= max.val) {
            // insertVal是最大值或者最小值，插入最大值和最小值之间
            position = max;
        } else {
            // insertVal在最大值和最小值之间，需要寻找cur.val <= insertVal && cur.next.val >= insertVal
            while (!(position.val <= insertVal && position.next.val >= insertVal)) {
                position = position.next;
            }
        }

        // 插入节点
        insertNode.next = position.next;
        position.next = insertNode;

        return head;
    }
}