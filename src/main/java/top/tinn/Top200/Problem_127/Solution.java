package top.tinn.Top200.Problem_127;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Solution
 * @Description
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * @Author Tinn
 * @Date 2020/4/18 15:16
 */
public class Solution {
    /*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0 || !wordList.contains(endWord)) return 0;
        //dfs
        boolean[] visited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) visited[idx] = true;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            while (size>0){
                String start = queue.poll();
                for (int i = 0; i < wordList.size(); i++){
                    if (visited[i]) continue;
                    String str = wordList.get(i);
                    if (!isValid(start, str)) continue;
                    if (str.equals(endWord)) return count + 1;
                    visited[i] = true;
                    queue.offer(str);
                }
                size--;
            }
        }
        return 0;
    }*/



    private boolean isValid(String a, String b){
        if (a.length() != b.length()) return false;
        int count = 0;
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i))
                count++;
            if (count > 2) return false;
        }
        return count == 1;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        //double-dfs
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.offer(start);
        queue2.offer(end);
        visited1.add(start);
        visited2.add(end);
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()){
            count++;
            if (queue1.size() > queue2.size()){
                Queue<Integer> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                Set<Integer> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size = queue1.size();
            while (size > 0){
                String s = wordList.get(queue1.poll());
                for (int i = 0; i < wordList.size(); i++){
                    if (visited1.contains(i)) continue;
                    String str = wordList.get(i);
                    if (!isValid(s, str)) continue;
                    if (visited2.contains(i)) return count + 1;
                    visited1.add(i);
                    queue1.offer(i);
                }
                size--;
            }
        }
        return 0;
    }
    @Test
    public void test(){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.stream(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})
                .collect(Collectors.toList());
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
