package top.tinn.剑指offer.Interview_25;

import top.tinn.utils.ListNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 20:28
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), curr = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        if (l1 != null)
            curr.next = l1;
        if (l2 != null)
            curr.next = l2;
        return dummy.next;
    }
}
