package top.tinn.Over200.Problem_208;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Trie
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/29 22:31
 */
public class Trie {

    private class TrieNode{
        private boolean isEnd;
        private TrieNode[] next = new TrieNode[26];
    }

    private TrieNode node;

    /** Initialize your data structure here. */
    public Trie() {
        node = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode root = node;
        for (char c : word.toCharArray()){
            if (root.next[c - 'a'] == null){
                root.next[c - 'a'] = new TrieNode();
            }
            root = root.next[c - 'a'];
        }
        root.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode root = node;
        for (char c : word.toCharArray()){
            if (root.next[c - 'a'] == null){
                return false;
            }
            root = root.next[c - 'a'];
        }
        return root.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode root = node;
        for (char c : prefix.toCharArray()){
            if (root.next[c - 'a'] == null){
                return false;
            }
            root = root.next[c - 'a'];
        }
        return true;
    }

    @Test
    public void test(){
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.startsWith("appl");
    }

}
