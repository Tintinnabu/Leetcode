package top.tinn.NowCoder.fiveeight_0921.Problem_01;

import netscape.security.UserTarget;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Tinn
 * @Date: 2020/9/21 20:18
 */
public class Solution {
    /**
     *
     * @param input string字符串
     * @return int整型
     */
    public int calculate (String input) {
        // write code here
        StringBuilder sb = new StringBuilder();
        //去除空格
        for (char c : input.toCharArray()){
            if (c != ' '){
                sb.append(c);
            }
        }
        List<Character> symbols = new ArrayList<>();
        int i = 0;
        Stack<Integer> integers = new Stack<>();
        while (i < sb.length()){
            int pre = 0;
            while (i < sb.length() && Character.isDigit(sb.charAt(i))){
                pre = 10 * pre + sb.charAt(i) - '0';
                i++;
            }
            integers.push(pre);
            while (i < sb.length() && (sb.charAt(i) == '*' || sb.charAt(i) == '/')){
                char sym = sb.charAt(i++);
                int next = 0;
                while (i < sb.length() && Character.isDigit(sb.charAt(i))){
                    next = 10 * next + sb.charAt(i) - '0';
                    i++;
                }
                int now;
                if (sym == '*'){
                    now = next * integers.pop();
                }else {
                    now = integers.pop() / next;
                }
                integers.push(now);
            }
            if (i < sb.length()){
                symbols.add(sb.charAt(i++));
            }
        }
        int ans = integers.get(0);
        for (int ii = 1; ii < integers.size(); ii++){
            if (symbols.get(ii - 1) == '-'){
                ans -= integers.get(ii);
            }else {
                ans += integers.get(ii);
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(calculate("5/2 + 6 * 4 / 3+ 2 /2"));
    }
}
