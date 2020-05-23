package top.tinn.Top200.Problem_017;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/23 21:43
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return ret;
        }
        String[] map = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
        backtrack(digits, new StringBuilder(), ret, map);
        return ret;
    }

    private void backtrack(String digits, StringBuilder stringBuilder, List<String> ret, String[] map) {
        if (digits.length() == 0){
            ret.add(stringBuilder.toString());
        }else {
            String s = map[digits.charAt(0) - '0'];
            for (int i = 0; i < s.length(); i++){
                stringBuilder.append(s.charAt(i));
                backtrack(digits.substring(1), stringBuilder, ret, map);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }
}
