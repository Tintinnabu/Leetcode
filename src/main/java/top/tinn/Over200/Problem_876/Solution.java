package top.tinn.Over200.Problem_876;

import top.tinn.utils.ListNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/9 16:42
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            if (fast.next == null) return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
