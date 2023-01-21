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
 * 思路:将这个链表看成一张图，深度优先搜索
 *  1.准备一个哈希表和一个队列。
 *  2.将head加入队列
 *  3.遍历队列，取出每一个老的节点，创建新的节点，并复制next指针和random指针(哈希表里面没有)
 * 
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
class Solution {
    public Node copyRandomList(Node head) {
        // 排除不合法的情况
        if (null == head) {
            return null;
        }
        // 用来保存创建过的新节点和老节点的对应关系
        Map<Node, Node> hash = new HashMap<>();
        // 队列
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            // 取出节点
            Node old = queue.poll();
            // 生成新节点
            Node newNode = new Node(old.val);
            if (hash.containsKey(old)) {
                // 新节点生成过
                newNode = hash.get(old);
            } else {
                // 新节点没有生成过
                hash.put(old, newNode);
            }

            // 补充next指针
            if (null != old.next && !hash.containsKey(old.next)) {
                // next指向的节点不存在进行创造
                queue.offer(old.next);
                hash.put(old.next, new Node(old.next.val));
            }
            newNode.next = null == old.next ? null : hash.get(old.next);


            // 补充random指针
            if (null != old.random && !hash.containsKey(old.random)) {
                // random指向的节点不存在进行创造
                queue.offer(old.random);
                hash.put(old.random, new Node(old.random.val));
            }
            newNode.random = null == old.random ? null : hash.get(old.random);
        }

        return hash.get(head);
    }
}