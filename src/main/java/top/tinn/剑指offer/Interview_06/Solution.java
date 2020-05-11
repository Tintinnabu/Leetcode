package top.tinn.剑指offer.Interview_06;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PrintListInReversedOrder
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 9:28
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        ListNode tail = new ListNode(Integer.MAX_VALUE);
        int cnt = 0;
        while (head != null){
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
            cnt ++;
        }
        int[] ret = new int[cnt];
        int i = 0;
        while (tail.val != Integer.MAX_VALUE){
            ret[i++] = tail.val;
            tail = tail.next;
        }
        return ret;
    }

    public int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] ret = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()){
            ret[i++] = stack.pop();
        }
        return ret;
    }

    private List<Integer> list = new ArrayList<>();
    public int[] reversePrint3(ListNode head) {
        helper(head);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void helper(ListNode head) {
        if (head == null) return;
        if (head.next != null){
            helper(head.next);
        }
        list.add(head.val);
    }


    public void printListInReversedOrder(ListNode head){
        if (head == null) return;
        if (head.next == null) {
            System.out.println(head.val);
            return;
        }
        ListNode tail = new ListNode(Integer.MAX_VALUE);
        while (head != null){
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        while (tail.val != Integer.MAX_VALUE){
            System.out.println(tail.val);
            tail = tail.next;
        }
    }

    public void printListInReversedOrder2(ListNode head){
        if (head == null) return;
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public void printListInReversedOrder3(ListNode head){
        if (head == null) return;
        if (head.next != null){
            printListInReversedOrder3(head.next);
        }
        System.out.println(head.val);
    }

    @Test
    public void test(){
        String listNode = "[1,2,3,4]";
        printListInReversedOrder(MainClass.stringToListNode(listNode));
        printListInReversedOrder2(MainClass.stringToListNode(listNode));
        printListInReversedOrder3(MainClass.stringToListNode(listNode));
    }
}
