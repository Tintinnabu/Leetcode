package top.tinn.Top200.Problem_024;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

/**
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=head;
        ListNode pre=dummy;
        while (curr!=null&&curr.next!=null){
            ListNode temp=curr.next;
            curr.next=curr.next.next;
            temp.next=curr;
            pre.next=temp;
            pre=curr;
            curr=curr.next;
        }
        return dummy.next;
    }

    @Test
    public void test(){
        String listnode="[1,2,3,4]";
        ListNode node=swapPairs(MainClass.stringToListNode(listnode));
        System.out.println(MainClass.listNodeToString(node));
    }
}
