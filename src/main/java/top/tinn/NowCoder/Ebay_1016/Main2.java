package top.tinn.NowCoder.Ebay_1016;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/10/16 19:35
 */
public class Main2 {
    static Set<Character> set;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        set = new HashSet<>();
        set.addAll(Arrays.asList('(',')','[',']','{','}'));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            String str = scanner.nextLine();
            if (isMatched(str)){
                sb.append("Yes\n");
            }else {
                sb.append("No\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean isMatched(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()){
            if (!set.contains(c)){
                return false;
            }
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char peek = stack.peek();
                if ((peek == '[' && c == ']') ||
                        (peek == '(' && c == ')') ||
                        (peek == '{' && c == '}')){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
