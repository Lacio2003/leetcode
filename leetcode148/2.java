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
    自下而上的归并排序
    时间复杂度:O(nlogn)
    空间复杂度:O(1)
*/
class Solution {
    public static ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        // 先统计长度f
        ListNode p = dummyHead.next;
        int length = 0;
        while(p != null){
            ++length;
            p = p.next;
        }
        // 循环开始切割和合并
        for(int size = 1; size < length; size <<= 1){
            ListNode cur = dummyHead.next;
            ListNode tail = dummyHead;
            while(cur != null){
                ListNode left = cur;
                ListNode right = cut(cur, size); // 链表切掉size 剩下的返还给right
                cur = cut(right, size); // 链表切掉size 剩下的返还给cur
                // 合并这一部分的链表
                tail.next = merge(left, right);
                while(tail.next != null){
                    tail = tail.next; // 保持最尾端
                }
            }
        }
        return dummyHead.next;
    }

    /**
     * 将链表L切掉前n个节点 并返回后半部分的链表头
     * @param head
     * @param n
     * @return
     */
    public static ListNode cut(ListNode head, int n){
        if(n <= 0) return head;
        ListNode p = head;
        // 往前走n-1步
        while(--n > 0 && p != null){
            p = p.next;
        }
        if(p == null) return null;
        ListNode next = p.next;
        p.next = null;
        return next;
    }

    /**
     * 合并list1和list2
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE), p = dummyHead;
        
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            } else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        
        // 链接剩余的部分
        p.next = null == list1 ? list2 : list1;

        return dummyHead.next;
    }
}