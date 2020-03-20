package top.tinn.Top200.Problem_146;

import java.util.Hashtable;

public class LRUCache2 {

    private Hashtable<Integer,DLinkedNode> cache=new Hashtable<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public LRUCache2(int capacity){
        this.size=0;
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key){
        DLinkedNode node=cache.get(key);
        if (node==null) return -1;
        moveToHead(node);
        return node.value;
    }



    public void put(int key,int value){
        DLinkedNode node=cache.get(key);
        if (node==null){
            DLinkedNode newNode=new DLinkedNode();
            newNode.key=key;
            newNode.value=value;
            cache.put(key,newNode);
            addNode(newNode);
            size++;
            if(size>capacity){
                DLinkedNode tail=popTail();
                cache.remove(tail.key);
                size--;
            }
        }else {
            node.value=value;
            moveToHead(node);
        }
    }




    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node){
        node.prev=head;
        node.next=head.next;
        head.next=node;
        node.next.prev=node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private DLinkedNode popTail() {
        DLinkedNode res=tail.prev;
        removeNode(res);
        return res;
    }
}
