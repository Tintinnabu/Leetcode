package top.tinn.BitProblem.Problem_389;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/15 15:57
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int i = 0,result = 0;
        for ( ; i<s1.length ; i++){
            result ^= s1[i];
            result ^= s2[i];
        }
        result ^=s2[i];
        return (char)result;
    }
}
