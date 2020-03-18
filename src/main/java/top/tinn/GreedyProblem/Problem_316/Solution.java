package top.tinn.GreedyProblem.Problem_316;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 316. 去除重复字母
 *
 * 316. 去除重复字母
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 *
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 *
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        int len=s.length();
        if (len<2) return s;
        boolean[] used=new boolean[26];
        int[] lastIndex=new int[26];
        for (int i=0;i<len;i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<len;i++){
            char c=s.charAt(i);
            if (used[c-'a']) continue;
            while (!stack.isEmpty()&&stack.peek()>c&&lastIndex[stack.peek()-'a']>i){
                int top=stack.pop();
                used[top-'a']=false;
            }
            stack.push(c);
            used[c-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }

    public String removeDuplicateLetters2(String s) {
        int len=s.length();
        if (len<2) return s;
        boolean[] used=new boolean[26];
        int[] lastIndex=new int[26];
        for (int i=0;i<len;i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        Stack<Character> stack=new Stack<>();
        stack.push('a');
        for (int i=0;i<len;i++){
            char c=s.charAt(i);
            if (used[c-'a']) continue;
            while (stack.peek()>c&&lastIndex[stack.peek()-'a']>i){
                int top=stack.pop();
                used[top-'a']=false;
            }
            stack.push(c);
            used[c-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        int size=stack.size();
        for (int i=0;i<size-1;i++)
            sb.insert(0,stack.pop());
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(removeDuplicateLetters2("cbacdcbc"));
    }
}
