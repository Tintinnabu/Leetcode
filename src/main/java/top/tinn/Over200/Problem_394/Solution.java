package top.tinn.Over200.Problem_394;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> multiStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int multi = 0;
        for (char c : s.toCharArray()){
            if (c >= '0' && c <= '9'){
                multi = 10 * multi + c - '0';
            }else if (c == '['){
                multiStack.push(multi);
                multi = 0;
                stringStack.push(sb.toString());
                sb = new StringBuilder();
            }else if (c == ']'){
                int curMulti = multiStack.pop();
                StringBuilder tmp = new StringBuilder(stringStack.pop());
                for (int i = 0; i < curMulti; i++){
                    tmp.append(sb);
                }
                sb = tmp;
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String decodeString2(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                multi = 10 * multi + s.charAt(i) - '0';
            }else if (s.charAt(i) == '['){
                String[] temp = dfs(s, i + 1);
                //更新同层下dfs后的i
                i = Integer.parseInt(temp[0]);
                while(multi > 0) {
                    res.append(temp[1]);
                    multi--;
                }
            }else if (s.charAt(i) == ']'){
                return new String[]{String.valueOf(i), res.toString()};
            }else {
                res.append(s.charAt(i));
            }
            i++;
        }
        return new String[]{res.toString()};
    }


    @Test
    public void test(){
        System.out.println(decodeString2("2[ad3[c]]"));
    }
}
