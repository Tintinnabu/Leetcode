package top.tinn.剑指offer.Interview_35;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/1 10:00
 */
public class Solution {
    private class Node{
        private int val;
        private Node next;
        private Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Node cur = head, cur2 = head;
        if (cur == null) return null;
        while (cur != null){
            Node copyCur = new Node(cur.val);
            copyCur.next = cur.next;
            cur.next = copyCur;
            cur = copyCur.next;
        }
        while (cur2 != null){
            if (cur2.random != null){
                cur2.next.random = cur2.random.next;
            }
            cur2 = cur2.next.next;
        }
        // 将链表一分为二
        Node copyHead = head.next;
        cur = head;
        Node curCopy = head.next;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            if (curCopy.next != null) {
                curCopy.next = curCopy.next.next;
                curCopy = curCopy.next;
            }
        }
        return copyHead;
    }


    @Test
    public void test(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.random =node1;
        Node copyNode = copyRandomList(node1);
        System.out.println(copyNode);
    }
}
