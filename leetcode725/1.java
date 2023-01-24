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
    思路:
        1.准备一个k长度的数组
        2.获取链表的长度
        3.使用链表的长度%k，得到余数，使用一个变量将余数进行存储
        4.根据长度k，遍历链表，最外层循环是k的长度，
            根据得到的余数和k获取当需要遍历的次数
            在合适的地方断开链表
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // 1.准备一个k长度的数组
        ListNode[] ans = new ListNode[k];

        // 2.获取链表的长度
        int length = 0;
        for (ListNode p = head; null != p; p = p.next) {
            length++;
        }

        // 3.使用链表的长度%k，得到余数，使用一个变量将余数进行存储
        int consult = length / k, remainder = length % k;

        // 4.根据长度k，遍历链表，最外层循环是k的长度，
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            // 链表已经是空，无法再次分割
            if (null == cur) {
                continue;
            }

            ans[i] = cur;
            // 在合适的地方进行切断
            int count = consult + (remainder > 0 ? 1 : 0);
            remainder--;

            // 寻找需要切断的地方的节点
            for (int j = 1; null != cur.next && j < count; j++) {
                cur = cur.next;
            }

            ListNode nextNode = cur.next;
            // 进行切断
            cur.next = null;
            cur = nextNode;
        }

        return ans;
    }
}