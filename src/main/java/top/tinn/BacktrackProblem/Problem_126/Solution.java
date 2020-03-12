package top.tinn.BacktrackProblem.Problem_126;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 126. 单词接龙 II
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
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
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: []
 *
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result=new ArrayList<>();
        if (!wordList.contains(endWord)) return result;
        boolean[] used=new boolean[wordList.size()];
        backtrack(beginWord,endWord,wordList,new ArrayDeque<>(),used,result);
        return result;
    }

    private void backtrack(String beginWord, String endWord, List<String> wordList, ArrayDeque<String> temp, boolean[] used,List<List<String>> result) {
        if (temp.size()>0&&temp.getLast().equals(endWord)&&temp.size()<=wordList.size()+2){
            if (result.size()<1)
                result.add(new ArrayList<>(temp));
            else {
                if (temp.size()==result.get(0).size()) result.add(new ArrayList<>(temp));
                else if (temp.size()<result.get(0).size()){
                    result.clear();
                    result.add(new ArrayList<>(temp));
                }
            }
        }
        if (temp.size()>wordList.size()+2) return;
        for (int i=0;i<wordList.size();i++){
            if (!used[i]&&differentAlpha(beginWord,wordList.get(i))==1){
                used[i]=true;
                temp.addLast(beginWord);
                backtrack(wordList.get(i),endWord,wordList,temp,used,result);
                used[i]=false;
                temp.removeLast();
            }
        }
    }

    private int differentAlpha(String str1,String str2){
        int count=0;
        if (str1.length()!=str2.length()) return 0;
        for (int i=0;i<str1.length();i++){
            if (str1.charAt(i)!=str2.charAt(i))
                count++;
        }
        return count;
    }

    @Test
    public void test(){
        String beginWord = "a";
        String  endWord = "c";
        List<String> wordList =new ArrayList<String>(){{add("a");add("b");add("c");}};
        System.out.println(findLadders(beginWord,endWord,wordList));

    }
}
