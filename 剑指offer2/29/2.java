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
        1.创建插入节点
        2.判断情况，如果head为空或者只有节点直接插入节点，返回即可。
        3.准备一个cur指针，指向head，next指针指向cur的下一个，
            如果cur.val <= insertVal && insertVal <= next.val则停止，插入节点
            如果cur.val > next.val，检查insertVal <= cur.val ||  insertVal >= next.val
            如果以上情况都不满足，就说明链表里面的值相等。随便插入一个位置即可
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        // 1.创建插入节点
        Node insertNode = new Node(insertVal);
        insertNode.next = insertNode;
        // 2.排序特殊的情况
        if (null == head) {
            return insertNode;
        }

        if (head == head.next) {
            insertNode.next = head.next;
            head.next = insertNode;
            return head;
        }

        // 3.遍历啊链表，进行其他情况的判断
        Node cur = head, next = head.next;
        while (next != head) {
            if (cur.val <= insertVal && insertVal <= next.val) {
                // insertVal不是最大值或者最小值
                break;
            }
            if (cur.val > next.val) {
                if (insertVal <= next.val || insertVal >= cur.val) {
                // insertVal是最大值或者最小值
                    break;
                }
            }

            cur = cur.next; 
            next = next.next;
        }

        // 插入节点
        insertNode.next = next;
        cur.next = insertNode;

        return head;
    }
}