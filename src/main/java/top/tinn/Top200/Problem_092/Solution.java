package top.tinn.Top200.Problem_092;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

/**
 * 92. 反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy,curr=head;
        int time=0;
        while (time<m-1){
            pre=pre.next;
            curr=curr.next;
            time++;
        }
        while (m<n){
            ListNode temp=curr.next;
            curr.next=curr.next.next;
            temp.next=pre.next;
            pre.next=temp;
            m++;
        }
        return dummy.next;
    }


    @Test
    public void test(){
        ListNode head= MainClass.stringToListNode("[1,2,3,4,5]");
        System.out.println(MainClass.listNodeToString(reverseBetween(head,4,5)));
    }
}
