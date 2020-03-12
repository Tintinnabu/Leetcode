package top.tinn.BacktrackProblem.Problem_140;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    int maxWordLength;
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result=new ArrayList<>();
        wordDict.sort((String a,String b)->(b.length()-a.length()));
        if (canWordBreak(s,wordDict))
            backtrack(s,wordDict,result,0,new ArrayList<>());
        return result;
    }

    private boolean canWordBreak(String s, List<String> wordDict) {
        //dp[i]表示字符串s的前i个字符能否拆分成wordDict
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        maxWordLength=0;
        for(String str:wordDict){
            maxWordLength= Math.max(maxWordLength, str.length());
        }
        for(int i=1;i<=s.length();i++){
            for(int j=Math.max(0,i-maxWordLength);j<i;j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private void backtrack(String s, List<String> wordDict,List<String> result,int currPos,List<Integer> temp){
        if (currPos==s.length()){
            StringBuilder sb=new StringBuilder(s);
            for (int i=temp.size()-2;i>=0;i--)
                sb.insert(temp.get(i)," ");
            result.add(sb.toString());
            return;
        }
        for (int j=currPos+1;j<=s.length()&&j<=currPos+maxWordLength;j++){
            if (wordDict.contains(s.substring(currPos,j))){
                temp.add(j);
                backtrack(s,wordDict,result,j,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    @Test
    public void test(){
        String s="pineapplepenapple";
        List<String> wordDict=new ArrayList<String>(){{add("apple");add("pen");add("applepen");add("pine");add("pineapple");}};
        System.out.println(wordBreak(s,wordDict));
    }
}
