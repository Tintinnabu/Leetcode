package top.tinn.BacktrackProblem.Problem_211;

import java.util.ArrayList;
import java.util.List;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordDictionary {
    class Node{
        private Node[] next;
        private boolean isWord;

        public Node(){
            next=new Node[26];
            isWord=false;
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
       int len=word.length();
       Node curNode=root;
       for (int i=0;i<len;i++){
           char curChar=word.charAt(i);
           Node next=curNode.next[curChar-'a'];
           if (next==null){
               curNode.next[curChar-'a']=new Node();
           }
           curNode=curNode.next[curChar-'a'];
       }
       if (!curNode.isWord) curNode.isWord=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word,root,0);
    }

    private boolean match(String word, Node node, int start) {
        if (start==word.length()) return node.isWord;
        char alpha=word.charAt(start);
        if (alpha=='.'){
            for (int i=0;i<26;i++){
                if (node.next[i]!=null&&match(word,node.next[i],start+1))
                    return true;
            }
            return false;
        }else {
            if (node.next[alpha-'a']==null) return false;
            return match(word,node.next[alpha-'a'],start+1);
        }
    }
}
