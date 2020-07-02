package top.tinn.InterviewProblem.面试题02_05;

import top.tinn.utils.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), pre = dummy;
        int c = 0;
        while (l1 != null || l2 != null || c > 0){
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + c;
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            c = sum / 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
