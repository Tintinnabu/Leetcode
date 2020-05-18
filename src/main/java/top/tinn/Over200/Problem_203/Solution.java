package top.tinn.Over200.Problem_203;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 16:45
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode=new ListNode(val-1);
        dummyNode.next=head;
        ListNode prev=dummyNode;
        //确保当前结点后还有结点
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }

    @Test
    public void test(){
        String tree = "[6,6]";
        ListNode node = removeElements(MainClass.stringToListNode(tree), 6);
    }
}
