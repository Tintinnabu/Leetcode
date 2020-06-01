package top.tinn.Over200.Problem_234;

import org.junit.jupiter.api.Test;
import sun.applet.Main;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/6/1 15:48
 */
public class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null){
                return true;
            }
            //默认为奇数
            boolean mark = false;
            ListNode slow = head, fast = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast == null){
                //偶数
                mark = true;
            }
            ListNode cur = head;
            ListNode nHead = head;
            while(cur.next != slow){
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = nHead;
                nHead = next;
            }
            if (!mark){
                slow = slow.next;
            }
            while(slow != null){
                if (nHead.val != slow.val){
                    return false;
                }
                slow = slow.next;
                nHead = nHead.next;
            }
            return true;
        }

    @Test
    public void test(){
        String node = "[1,2, 2 , 1]";
        System.out.println(isPalindrome(MainClass.stringToListNode(node)));
    }
}
