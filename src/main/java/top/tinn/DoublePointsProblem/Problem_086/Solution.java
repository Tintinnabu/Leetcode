package top.tinn.DoublePointsProblem.Problem_086;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

/**
 * 86. 分隔链表
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1=new ListNode(0),ret=dummy1;
        ListNode dummy2=new ListNode(0),dummy2head=dummy2;
        while(head!=null){
            ListNode temp=head;
            head=head.next;
            if (temp.val<x){
                dummy1.next=temp;
                dummy1=dummy1.next;
                dummy1.next=null;
            }else{
                dummy2.next=temp;
                dummy2=dummy2.next;
                dummy2.next=null;
            }
        }
        dummy1.next=dummy2head.next;
        return ret.next;
    }

    @Test
    public void test(){
        String listnode="[1,4,3,2,5,2]";
        ListNode input= MainClass.stringToListNode(listnode);
        ListNode ret=partition(input,3);
        System.out.println(MainClass.listNodeToString(ret));
    }
}
