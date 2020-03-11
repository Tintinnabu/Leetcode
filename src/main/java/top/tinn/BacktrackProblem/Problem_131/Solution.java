package top.tinn.BacktrackProblem.Problem_131;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        backtrack(s,new ArrayList<>(),result);
        return result;
    }

    private void backtrack(String s,List<String> temp,List<List<String>> result){
        if (s.length()==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i=1;i<=s.length();i++){
            if (isPali(s.substring(0,i))){
                temp.add(s.substring(0,i));
                backtrack(s.substring(i),temp,result);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPali(String s){
        int l=0,r=s.length()-1;
        while (l<r){
            if (s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(partition("aab"));
    }
}
