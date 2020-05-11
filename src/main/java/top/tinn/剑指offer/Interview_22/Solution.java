package top.tinn.剑指offer.Interview_22;

import top.tinn.utils.ListNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 16:13
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 1; i < k; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            head = head.next;
        }
        return head;
    }
}
