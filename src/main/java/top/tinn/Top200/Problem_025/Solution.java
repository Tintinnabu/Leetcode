package top.tinn.Top200.Problem_025;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

/**
 * 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=head;
        ListNode pre=dummy;
        while (curr!=null){
            int j=k,i=k;
            ListNode iter=curr;
            while (i>0&&iter!=null){
                iter=iter.next;i--;
            }
            if (i>0) break;
            while (j > 1 ){
                ListNode temp=curr.next;
                curr.next=curr.next.next;
                temp.next=pre.next;
                pre.next=temp;
                j--;
            }
            pre=curr;
            curr=curr.next;
        }
        return dummy.next;
    }



    @Test
    public void test(){
        String listnode="[1,2,3,4,5]";
        ListNode node=reverseKGroup(MainClass.stringToListNode(listnode),3);
        System.out.println(MainClass.listNodeToString(node));
    }
}
