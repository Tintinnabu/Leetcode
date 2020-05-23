package top.tinn.Top200.Problem_020;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/23 22:00
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (stack.size() == 0 || c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                char peek = stack.peek();
                if (isMatched(peek, c)){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatched(char peek, char c) {
        return (peek == '(' && c == ')') || (peek == '[' && c == ']')
                || (peek == '{' && c == '}');
    }
}
