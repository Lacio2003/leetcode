/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
    将结点放入优先级队列当中，这样结点就是有顺序的了。然后再将结点全部都拿出来。
    时间复杂度:O(klogn), n是结点的个数,log是每一个结点操作花费的时间
    空间复杂度:O(k)
 */
class Solution {
    // 为了让结点可以放进优先队列，需要声明一个比较器
    class NodeComparator implements Comparator<ListNode>{
        public int compare(ListNode first, ListNode second) {
            return second.val - first.val;
        }
    }

    // 优先级队列
    PriorityQueue<ListNode> queue = new PriorityQueue<>(new NodeComparator());
    public ListNode mergeKLists(ListNode[] lists) {
        // 先将结点去全部都放入优先级队列
        for (ListNode node : lists) {
            while (null != node) {
                queue.offer(node);
                node = node.next;
            }
        }

        // 将结点全部取出来
        ListNode newHead = new ListNode(0);
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            node.next = newHead.next;
            newHead.next = node;
        }

        return newHead.next;
    }
}