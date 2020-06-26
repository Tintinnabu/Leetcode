package top.tinn.InterviewProblem.面试题02_01;

import top.tinn.utils.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> map = new HashSet<>();
        ListNode cur = head;
        ListNode dummy = new ListNode(0), pre = dummy;
        while (cur != null){
            if (!map.contains(cur.val)){
                pre.next = cur;
                pre = cur;
                map.add(cur.val);
            }
            cur = cur.next;
        }
        pre.next = null;
        return dummy.next;
    }
}
