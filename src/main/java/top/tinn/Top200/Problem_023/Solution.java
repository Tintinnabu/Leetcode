package top.tinn.Top200.Problem_023;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

import java.util.PriorityQueue;

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
    //O(NK)
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

    //O(NlogK)
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b)->(a.val - b.val));
        for (ListNode node : lists){
            if (node != null){
                priorityQueue.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!priorityQueue.isEmpty()){
            ListNode minNode = priorityQueue.poll();
            if (minNode.next != null){
                priorityQueue.offer(minNode.next);
            }
            cur.next = minNode;
            cur = minNode;
        }
        return dummy.next;
    }

    //O(NlogK)  两两合并 迭代
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        int k = lists.length;
        while (k > 1){
            int idx = 0;
            for (int i = 0; i < k; i += 2){
                if (i == k - 1){
                    lists[idx++] = lists[i];
                }else {
                    lists[idx++] = merge2Lists(lists[i], lists[i + 1]);
                }
            }
            k = idx;
        }
        return lists[0];
    }

    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = merge2Lists(list1.next, list2);
            return list1;
        }
        list2.next = merge2Lists(list1, list2.next);
        return list2;
    }

    //O(NlogK)  两两合并 递归
    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi){
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        //归并
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return merge2Lists(l1, l2);
    }


    @Test
    public void test(){
        String listnode1="[1,4,5]";
        String listnode2="[1,3,4]";
        String listnode3="[2,6]";
        ListNode[] lists=new ListNode[]{MainClass.stringToListNode(listnode1),MainClass.stringToListNode(listnode2),MainClass.stringToListNode(listnode3)};
        ListNode ret=mergeKLists4(lists);
        System.out.println(MainClass.listNodeToString(ret));
    }
}
