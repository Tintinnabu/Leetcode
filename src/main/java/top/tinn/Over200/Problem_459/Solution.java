package top.tinn.Over200.Problem_459;

/**
 * @Author: Tinn
 * @Date: 2020/8/24 9:33
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        String ssc = ss.substring(1, ss.length() - 1);
        return ssc.contains(s);
    }

    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        if (n < 2){
            return false;
        }
        for (int subsize = 1; subsize < n; subsize++){
            if (n % subsize != 0){
                continue;
            }
            if (check(s, n, subsize)){
                return true;
            }
        }
        return false;
    }

    private boolean check(String s, int len, int subsize){
        for (int i = 0; i < subsize; i++){
            int index = i;
            char c = s.charAt(index);
            for (int cnt = 0; cnt < len / subsize; cnt++){
                if (s.charAt(index) != c){
                    return false;
                }
                index += subsize;
            }
        }
        return true;
    }
}
