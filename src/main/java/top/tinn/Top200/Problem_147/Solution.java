package top.tinn.Top200.Problem_147;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

/**
 * 147. 对链表进行插入排序
 *
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0),scan=head.next,pre,max=head;
        dummy.next=head;
        while (scan!=null){
            while (scan!=null&&scan.val>=max.val){
                scan=scan.next;
                max=max.next;
            }
            if (scan==null) break;
            pre=dummy;
            while (pre.next.val<scan.val){
                pre=pre.next;
            }
            max.next=scan.next;
            scan.next=pre.next;
            pre.next=scan;
            scan=max.next;
        }
        return dummy.next;
    }

    @Test
    public void test(){
        ListNode head= MainClass.stringToListNode("[-1,5,3,4,0]");
        ListNode ret=insertionSortList(head);
        System.out.println(MainClass.listNodeToString(ret));
    }
}
