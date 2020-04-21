package top.tinn.Problem_227;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @ClassName Solution
 * @Description
 * 227. 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * @Author Tinn
 * @Date 2020/4/20 20:38
 */
public class Solution {

    public int calculate(String s) {
        return dfs(s, new int[1]);
    }

    private int dfs(String s, int[] i){
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char op = '+';
        for (; i[0] < s.length(); i[0]++){
            char ch = s.charAt(i[0]);
            if (ch == '('){
                i[0]++;
                num = dfs(s, i);
            }
            if (Character.isDigit(ch)){
                num = 10 * num + ch - '0';
            }
            if (!Character.isDigit(ch) && ch != ' ' || i[0] == s.length() - 1){
                switch(op){
                    case '+':
                        stack.push(num); break;
                    case '-':
                        stack.push(-num); break;
                    case '*':
                        int pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                num = 0;
                op = ch;
            }
            if (ch == ')'){
                //i[0]++;
                break;
            }

        }
        int res = 0;
        while (!stack.isEmpty())
            res+=stack.pop();
        return res;
    }

    @Test
    public void test(){
        System.out.println(calculate("(32+2)*2"));
    }
}
