package top.tinn.Problem_394;

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
        StringBuilder sb=new StringBuilder();
        Stack<Integer> multyStack=new Stack<>();
        Stack<String> stringStack=new Stack<>();
        int multi=0;
        for(char c:s.toCharArray()){
            if(c>='0'&&c<='9') multi=10*multi+c-'0';
            else if(c=='['){
                multyStack.add(multi);
                stringStack.add(sb.toString());
                multi=0;
                sb=new StringBuilder();
            }else if(c==']'){
                StringBuilder tmp=new StringBuilder();
                int cur_multi=multyStack.pop();
                for(int i=0;i<cur_multi;i++) tmp.append(sb);
                sb=new StringBuilder(stringStack.pop()+tmp);
            }else
                sb.append(c);
        }
        return sb.toString();
    }


    @Test
    public void test(){
        System.out.println(decodeString("3[a2[c]]"));
    }
}
