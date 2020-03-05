package top.tinn.Problem_647;

import org.junit.jupiter.api.Test;

/**
 * 647. 回文子串
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private int count=0;
    public int countSubstrings(String s) {
        if (s==null||s.length()<1) return count;
        for(int i=0;i<s.length();i++){
            expandAroundCenter(s,i,i);
            expandAroundCenter(s,i,i+1);
        }
        return count;
    }

    private void expandAroundCenter(String s, int left, int right) {
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
    }

    @Test
    public void test(){
        String s="aabc";
        System.out.println(countSubstrings(s));
    }

}
