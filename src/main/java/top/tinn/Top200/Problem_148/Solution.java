package top.tinn.Top200.Problem_148;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/28 21:58
 */
public class Solution {
    //分治、归并
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode r = sortList(slow.next);
        slow.next = null;
        ListNode l = sortList(head);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l != null && r != null){
            if (l.val <= r.val){
                cur.next = l;
                l = l.next;
            }else{
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if(l != null)  cur.next=l;
        if(r != null)  cur.next=r;
        return dummy.next;
    }

    @Test
    public void test(){
        String l = "[4,2,1,3,5]";
        System.out.println(MainClass.listNodeToString(sortList(MainClass.stringToListNode(l))));
    }
}
