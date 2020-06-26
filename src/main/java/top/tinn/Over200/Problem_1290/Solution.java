package top.tinn.Over200.Problem_1290;

import top.tinn.utils.ListNode;

public class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null){
            ans <<= 1;
            ans += head.val;
            head = head.next;
        }
        return ans;
    }
}
