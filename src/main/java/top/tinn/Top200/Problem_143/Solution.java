package top.tinn.Top200.Problem_143;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 143. 重排链表
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head==null||head.next==null) return;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=head,fast=head;
        int index=0;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            index++;
        }
        if (fast==null) index--;
        int number=1;
        ListNode move=slow.next;
        while (move!=null){
            ListNode temp=slow.next;
            slow.next=move.next;
            ListNode start=head;
            for (int i=0;i<index-number;i++)
                start=start.next;
            temp.next=start.next;
            start.next=temp;
            move=slow.next;
            number++;
        }
    }

    @Test
    public void test(){
        ListNode head= MainClass.stringToListNode("[1,2,3,4]");
        reorderList(head);
        System.out.println(MainClass.listNodeToString(head));
    }
}
