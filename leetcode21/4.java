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

/**
 * website:https://leetcode.cn/problems/merge-two-sorted-lists/solutions/103891/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/
 * 思路:直接在原来的结点上进行修改
 * 时间复杂度:O(m+n)
 * 空间复杂度:O(m+n)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        } else if (null == list2) {
            return list1;
        } else if (list1.val < list2.val) {
            // list1小，所以list2不移动，list1移动。
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            // list2小，list1不一定，移动list2
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}