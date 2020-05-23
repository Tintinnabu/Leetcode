package top.tinn.Top200.Problem_019;

import top.tinn.utils.ListNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/23 21:55
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy, fast = dummy;
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
