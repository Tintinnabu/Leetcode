package top.tinn.Top200.Problem_138;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution {
    public Node copyRandomList(Node head) {
        Node dummy=new Node(0),pre=dummy;
        Map<Node,Node> map=new HashMap<>();
        Node cur=head;
        while (cur!=null){
            Node copy=new Node(cur.val);
            pre.next=copy;
            map.put(cur,copy);
            cur=cur.next;
            pre=pre.next;
        }
        Node start=dummy.next;
        while (head!=null){
            if (head.random!=null){
                start.random=map.get(head.random);
            }
            head=head.next;
            start=start.next;
        }
        return dummy.next;
    }
}
