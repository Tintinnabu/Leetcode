package top.tinn.DpProblem.Problem_032;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 *32. 最长有效括号
 *
 *给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 通过次数44,382提交次数148,589
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int ret=0;
        for (int i=0;i<s.length();i++){
            for (int j=i+1;j<s.length();j++){
                if (isParentheses(s,i,j)){
                    ret=Math.max(ret,j-i+1);
                }
            }
        }
        return ret;
    }

    private boolean isParentheses(String s, int i, int j) {
        Stack<Character> stack=new Stack<>();
        for (int k=i;k<=j;k++){
            char c=s.charAt(k);
            if (c=='(')
                stack.push(c);
            else {
                if (!stack.isEmpty()&&stack.peek()=='(')
                    stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

    //dp O(N)
    public int longestValidParentheses2(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++){
            if (chars[i] == ')'){
                if (chars[i - 1] == '('){
                    dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                }else if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '('){
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i -dp[i - 1] - 2] : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public int longestValidParentheses3(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses4(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    @Test
    public void test(){
        String s=")()())";
        System.out.println(longestValidParentheses2(s));
    }
}
