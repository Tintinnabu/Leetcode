package top.tinn.Top200.Problem_083;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        ListNode dummy=new ListNode(head.val-1);
        dummy.next=head;
        ListNode curr=head,pre=dummy;
        while (curr!=null){
            if (curr.val==pre.val){
                pre.next=curr.next;
                curr=curr.next;
            }else {
                curr=curr.next;
                pre=pre.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void test(){
        ListNode head= MainClass.stringToListNode("[1,1]");
        System.out.println(MainClass.listNodeToString(deleteDuplicates(head)));
    }
}
