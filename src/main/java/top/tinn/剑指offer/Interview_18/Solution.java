package top.tinn.剑指offer.Interview_18;

import top.tinn.utils.ListNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/7 17:04
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head;
        ListNode cur = head;
        while (cur.next.val != val)
            cur = cur.next;
        if (cur.next.next == null){
            cur.next = null;
        }else {
            cur.next = cur.next.next;
        }
        return head;
    }
}
