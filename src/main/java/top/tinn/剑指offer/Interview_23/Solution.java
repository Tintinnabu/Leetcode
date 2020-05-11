package top.tinn.剑指offer.Interview_23;

import top.tinn.utils.ListNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 16:16
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0), curr = dummy;
        while (head != null){
            ListNode temp = head.next;
            head.next = curr.next;
            curr.next = head;
            head = temp;
        }
        return dummy.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
