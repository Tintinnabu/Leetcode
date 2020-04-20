package top.tinn.Problem_328;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

/**
 * @ClassName Solution
 * @Description
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * @Author Tinn
 * @Date 2020/4/19 20:23
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = head;
        ListNode evenHead = new ListNode(0), dummy2 = evenHead;
        while (start.next != null){
            evenHead.next = start.next;
            evenHead = evenHead.next;
            start.next = start.next.next;
            if (start.next != null)
                start = start.next;
            else break;
        }
        evenHead.next = null;
        start.next = dummy2.next;
        return dummy.next;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while (odd.next != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    @Test
    public void test(){
        String listNode = "[1,2,3,4]";
        ListNode node = MainClass.stringToListNode(listNode);
        System.out.println(MainClass.listNodeToString(oddEvenList2(node)));;
    }
}
