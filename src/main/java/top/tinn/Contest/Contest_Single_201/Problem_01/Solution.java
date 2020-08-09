package top.tinn.Contest.Contest_Single_201.Problem_01;

import java.util.Stack;

public class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (!stack.isEmpty() && ((Character.isLowerCase(c) && stack.peek() == c - 'a' + 'A')
                    || (Character.isUpperCase(c) && stack.peek() == c - 'A' + 'a'))){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
