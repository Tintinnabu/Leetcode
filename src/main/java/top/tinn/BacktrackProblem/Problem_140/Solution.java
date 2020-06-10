package top.tinn.BacktrackProblem.Problem_140;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 140. 单词拆分 II
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        int maxLength = 0;
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        for (String word : wordDict){
            maxLength = Math.max(maxLength, word.length());
        }
        for (int i = 1; i <= len; i++){
            for(int j = Math.max(0, i - maxLength); j < i; j++){
                if (dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        if (dp[len]){
            dfs(s, wordSet, new LinkedList<>(), len, res, dp);
        }
        return res;
    }

    private void dfs(String s, Set<String> wordSet, LinkedList<String> temp, int end, List<String> res, boolean[] dp){
        if (end == 0){
            StringBuilder stringBuilder = new StringBuilder();
            for (String word : temp) {
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            res.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < end; i++){
            if (dp[i]){
                String suffix = s.substring(i, end);
                if (wordSet.contains(suffix)){
                    temp.add(0, suffix);
                    dfs(s, wordSet, temp, i, res, dp);
                    temp.removeFirst();
                }
            }
        }
    }

    @Test
    public void test(){
        String s="pineapplepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple","pen","applepen","pine","pineapple"));
        System.out.println(wordBreak(s,wordDict));
    }
}
