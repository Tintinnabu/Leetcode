package top.tinn.Over200.Problem_460;

import org.junit.jupiter.api.Test;
import sun.security.x509.DNSName;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public class LFUCache {
    private int capacity;
    private Map<Integer, DNode> cacheMap;
    private DNode head;
    private DNode tail;

    private static class DNode{
        int key;
        int value;
        int freq = 1;
        private DNode prev;
        private DNode next;
        public DNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        head = new DNode(-1, -1);
        tail = new DNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DNode node = cacheMap.get(key);
        if (node == null){
            return -1;
        }
        remove(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity < 1){
            return;
        }
        if (get(key) == -1){
            if (cacheMap.size() == capacity){
                DNode deleteNode = tail.prev;
                cacheMap.remove(deleteNode.key);
                deleteNode.key = key;
                deleteNode.value = value;
                cacheMap.put(key, deleteNode);
            }else {
                DNode node = new DNode(key,value);
                cacheMap.put(key, node);
                addToTail(node);
            }
        }else {
            cacheMap.get(key).value = value;
        }
    }

    private void addToTail(DNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private void addToHead(DNode node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 3 /* capacity (缓存容量) */ );

        cache.put(2, 2);
        cache.put(1, 1);
        cache.get(2);
        cache.get(1);
        cache.get(2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.get(4);

    }
}
