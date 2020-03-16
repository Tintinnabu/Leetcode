package top.tinn.DoublePointsProblem.Problem_061;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len=0;
        ListNode dummy=new ListNode(0),low=dummy,fast=dummy,countLen=dummy;
        dummy.next=head;
        while (countLen.next!=null){
            countLen=countLen.next;
            len++;
        }
        k=k%len;
        if (k==0) return head;
        while (k>0){
            fast=fast.next;
            k--;
        }

        while (fast.next!=null){
            fast=fast.next;
            low=low.next;
        }
        ListNode ret=low.next;
        fast.next=head;
        low.next=null;
        return ret;
    }


    @Test
    public void test(){
        String listnode="[1,2,3,4,5]";
        ListNode head= MainClass.stringToListNode(listnode);
        ListNode ret=rotateRight(head,0);
        System.out.println(MainClass.listNodeToString(ret));
    }

}
