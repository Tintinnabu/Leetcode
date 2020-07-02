package top.tinn.Over200.Problem_677;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    private Trie root;
    private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Trie(0);
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        if (map.containsKey(key)){
            int temp = val;
            val -= map.get(key);
            map.put(key, temp);
        }else{
            map.put(key, val);
        }
        Trie cur = root;
        for (char c : key.toCharArray()){
            if (cur.next[c - 'a'] == null){
                cur.next[c - 'a'] = new Trie(0);
            }
            cur.next[c - 'a'].value += val;
            cur = cur.next[c - 'a'];
        }
    }

    public int sum(String prefix) {
        Trie cur = root;
        for (char c : prefix.toCharArray()){
            if (cur.next[c - 'a'] == null){
                return 0;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.value;
    }

    class Trie{
        Trie[] next;
        int value;
        public Trie(int value){
            next = new Trie[26];
            this.value = value;
        }
    }

    @Test
    public void test(){
        insert("apple", 3);
        System.out.println(sum("ap"));
        insert("apple", 2);
        System.out.println(sum("a"));
    }
}
