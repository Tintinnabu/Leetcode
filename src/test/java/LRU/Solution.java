package LRU;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/9/4 16:40
 */
public class Solution {

    class DNode{
        DNode next;
        DNode prev;
        int val;
        int key;
        public DNode(int val){
            this.val = val;
        }

        public DNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public Solution(){
        head = new DNode(0);
        tail = new DNode(0);
        head.next = tail;
        tail.next = head;
        size = 0;
        map = new HashMap<>();
    }

    DNode head;
    DNode tail;
    int size;
    Map<Integer, DNode> map;
    int capacity;

    private void set(int key, int val){
        if (map.containsKey(key)){
            DNode node = map.get(key);
            node.val = val;
            delete(node);
            moveToFirst(node);
        }else{
            if(size == capacity){
                DNode last = tail.prev;
                delete(last);
                map.remove(last.key);
            }
            DNode node = new DNode(key, val);
            map.put(key, node);
            size++;
            moveToFirst(node);
        }
    }

    private int get(int key){
        if (map.containsKey(key)){
            DNode node = map.get(key);
            delete(node);
            moveToFirst(node);
            return node.val;
        }else{
            return -1;
        }
    }

    private void delete(DNode node){
        DNode prev = node.prev;
        DNode next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }

    private void moveToFirst(DNode node){
        DNode next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }

    public int[] LRU (int[][] operators, int k) {
        // write code here
        capacity = k;
        List<Integer> ans = new ArrayList<>();
        for (int[] operator : operators){
            if (operator[0] == 1){
                set(operator[1], operator[2]);
            }else{
                int temp = get(operator[1]);
                ans.add(temp);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] operators = new int[6][];
        operators[0] = new int[]{1,1,1};
        operators[1] = new int[]{1,2,2};
        operators[2] = new int[]{1,3,2};
        operators[3] = new int[]{2,1};
        operators[4] = new int[]{1,4,4};
        operators[5] = new int[]{2,2};
        int k = 3;
        int[] ans = solution.LRU(operators, k);
        System.out.println(Arrays.toString(ans));
    }
}