package top.tinn.Over200.Problem_206;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/28 22:37
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode nHead = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = nHead;
            nHead = cur;
            cur = temp;
        }
        return nHead;
    }

    @Test
    public void test(){
        String l = "[4,3,2,1]";
        System.out.println(MainClass.listNodeToString(reverseList(MainClass.stringToListNode(l))));
        System.out.println(MainClass.listNodeToString(reverseList2(MainClass.stringToListNode(l))));
    }
}
