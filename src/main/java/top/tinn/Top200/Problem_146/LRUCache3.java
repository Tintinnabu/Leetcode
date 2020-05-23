package top.tinn.Top200.Problem_146;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName LRUCache3
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/22 22:27
 */
public class LRUCache3 {
    private int capacity;
    private Map<Integer, DNode> cacheMap = new HashMap<>();
    private DNode head;
    private DNode tail;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DNode node = cacheMap.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(DNode node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key,int value){
        DNode node = cacheMap.get(key);
        if (node == null){
            node = new DNode(key, value);
            cacheMap.put(key, node);
            addNode(node);
            if (cacheMap.size() > capacity){
                DNode tail = popTail();
                cacheMap.remove(tail.key);
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DNode popTail() {
        DNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private class DNode{
        private int key;
        private int value;
        private DNode next;
        private DNode prev;

        public DNode() {
        }

        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
