package top.tinn.Over200.Problem_301;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * 301. 删除无效的括号
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 *
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 *
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 *
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 *
 * 输入: ")("
 * 输出: [""]
 * @Author Tinn
 * @Date 2020/4/18 14:16
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<String>();
        set.add(s);
        while (!set.isEmpty()){
            List<String> result = new ArrayList<>();
            for (String str : set){
                if (isValid(str)) result.add(str);
            }
            if (!result.isEmpty()) return result;
            HashSet<String> newSet = new HashSet<>();
            for (String str : set){
                for (int i = 0; i < str.length(); i++){
                    if (str.charAt(i) == '(' || str.charAt(i) == ')'){
                        newSet.add(str.substring(0, i) + str.substring(i+1));
                    }
                }
            }
            set = newSet;
        }
        return new ArrayList<String>();
    }

    private boolean isValid(String s){
        int count = 0;
        for (char c : s.toCharArray()){
            if (c == '(') count++;
            else if(c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    @Test
    public void test(){
        String s = "(a)())()";
        System.out.println(removeInvalidParentheses(s));
    }

}
