package top.tinn.剑指offer.Interview_52;

import top.tinn.utils.ListNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/2 16:40
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b){
            a = a.next;
            b = b.next;
            if (a == null && b == null) return null;
            if (a == null)
                a = headB;
            if (b == null)
                b = headA;
        }
        return  a;
    }
}
