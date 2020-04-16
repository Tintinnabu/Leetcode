package top.tinn.BitProblem.Problem_784;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Solution
 * @Description
 * 784. 字母大小写全排列
 * @Author Tinn
 * @Date 2020/4/15 20:42
 */
public class Solution {
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        for (char c: S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (StringBuilder an : ans) an.append(c);
            }
        }
        return ans.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }


    @Test
    public void test(){
        System.out.println(letterCasePermutation("a1b2"));
    }
}
