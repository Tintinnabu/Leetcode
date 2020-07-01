package top.tinn.Over200.Problem_460;

import org.junit.jupiter.api.Test;
import org.omg.CORBA.FREE_MEM;
import sun.security.x509.DNSName;
import top.tinn.utils.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public class LFUCache {

    private static class DNode{
        int key;
        int value;
        int freq = 1;
        private DNode prev;
        private DNode next;
        private FrequencyListNode frequencyListNode;
        public DNode(){}
        public DNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private static class FrequencyListNode{
        int freq;
        FrequencyListNode prev;
        FrequencyListNode next;
        DNode head;
        DNode tail;

        public FrequencyListNode(){
            head = new DNode();
            tail = new DNode();
            head.next = tail;
            tail.prev = head;
        }

        public FrequencyListNode(int freq){
            this();
            this.freq = freq;
        }

        public void removeNode(DNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void addNode(DNode node){
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            node.frequencyListNode = this;
        }

    }

    private int capacity;
    private int size;
    private Map<Integer, DNode> cacheMap;
    private FrequencyListNode head;
    private FrequencyListNode tail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        head = new FrequencyListNode();
        tail = new FrequencyListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DNode node = cacheMap.get(key);
        if (node == null){
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity < 1){
            return;
        }
        DNode node = cacheMap.get(key);
        if (node != null){
            node.value = value;
            freqInc(node);
        }else {
            if (size == capacity){
                //删除tail.tail.pre节点
                cacheMap.remove(tail.prev.tail.prev.key);
                tail.removeNode(tail.prev.tail.prev);
                size--;
                if (tail.prev.head.next == tail.prev.tail){
                    removeFrequecyListNode(tail.prev);
                }
            }
            DNode node1 = new DNode(key, value);
            cacheMap.put(key, node1);
            if (tail.prev.freq != 1){
                FrequencyListNode lastNode = new FrequencyListNode(1);
                addFrequencyListNode(lastNode, tail.prev);
                lastNode.addNode(node1);
            }else{
                tail.prev.addNode(node1);
            }
            size++;
        }
    }

    private void addFrequencyListNode(FrequencyListNode lastNode, FrequencyListNode prev) {
        lastNode.next = prev.next;
        prev.next.prev = lastNode;
        lastNode.prev = prev;
        prev.next = lastNode;
    }

    private void removeFrequecyListNode(FrequencyListNode prev) {
        prev.prev.next = prev.next;
        prev.next.prev = prev.prev;
    }

    private void freqInc(DNode node) {
        FrequencyListNode frequencyListNode = node.frequencyListNode;
        FrequencyListNode pre = frequencyListNode.prev;
        frequencyListNode.removeNode(node);
        if (frequencyListNode.head.next == frequencyListNode.tail){
            removeFrequecyListNode(frequencyListNode);
        }
        node.freq++;
        if (pre.freq != node.freq){
            FrequencyListNode frequencyListNode1 = new FrequencyListNode(node.freq);
            addFrequencyListNode(frequencyListNode1, pre);
            frequencyListNode1.addNode(node);
        }else {
            pre.addNode(node);
        }

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
