package top.tinn.Top200.Problem_082;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

import java.util.HashMap;
import java.util.Map;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0),pre=dummy;
        ListNode curr=head,next;
        while (curr!=null){
            next=curr.next;
            if (next!=null&&curr.val==next.val){
                int val=curr.val;
                while (curr!=null&&curr.val==val) curr=curr.next;
            }else {
                pre.next=curr;
                pre=pre.next;
                curr=curr.next;
            }
        }
        pre.next=null;
        return dummy.next;
    }


    @Test
    public void test(){
        ListNode head= MainClass.stringToListNode("[2,2,2,4,5,8,8,8]");
        System.out.println(MainClass.listNodeToString(deleteDuplicates(head)));
    }
}
