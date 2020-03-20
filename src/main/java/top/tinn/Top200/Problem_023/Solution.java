package top.tinn.Top200.Problem_023;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

/**
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        boolean end=true;
        ListNode dummy=new ListNode(0),ret=dummy;
        while (end){
            end=false;
            int minIndex=Integer.MAX_VALUE;
            int min=Integer.MAX_VALUE;
            for (int i=0;i<lists.length;i++){
                if (lists[i]!=null){
                    end=true;
                    if (lists[i].val<min){
                        minIndex=i;
                        min=lists[i].val;
                    }
                }
            }
            if (minIndex==Integer.MAX_VALUE) break;
            ListNode temp=lists[minIndex].next;
            lists[minIndex].next=null;
            dummy.next=lists[minIndex];
            dummy=dummy.next;
            lists[minIndex]=temp;
        }
        return ret.next;
    }


    @Test
    public void test(){
        String listnode1="[]";
        String listnode2="[]";
        String listnode3="[]";
        ListNode[] lists=new ListNode[]{MainClass.stringToListNode(listnode1),MainClass.stringToListNode(listnode2),MainClass.stringToListNode(listnode3)};
        ListNode ret=mergeKLists(lists);
        System.out.println(MainClass.listNodeToString(ret));
    }
}
