package top.tinn.NowCoder.Xiaomi_0916.Problem_01;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: Tinn
 * @Date: 2020/9/15 19:14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            if (helper(str)){
                ans.append("true\n");
            }else {
                ans.append("false\n");
            }
        }
        System.out.println(ans.toString());
    }

    private static boolean helper(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty() || !isMatch(stack.peek(), c)){
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }

    private static boolean isMatch(char l, char r) {
        if ((l == '(' && r == ')') || (l == '[' && r == ']')
        || (l == '{' && r == '}')){
            return true;
        }
        return false;
    }
}
