package top.tinn.InterviewProblem.面试题16_18;

import org.junit.jupiter.api.Test;

public class Solution {
    private int cnt_a;
    private int cnt_b;
    public boolean patternMatching(String pattern, String value) {
        cnt_b = cnt_a = 0;
        if (pattern.length() == 0){
            return value.length() == 0;
        }
        for (char c : pattern.toCharArray()){
            if (c == 'a') {
                cnt_a++;
            } else {
                cnt_b++;
            }
        }
        if (value.length() == 0){
            return cnt_a * cnt_b == 0;
        }

        int len = value.length();
        if (cnt_b == 0){
            if (len % cnt_a == 0){
                return helper(pattern, value, new int[]{len / cnt_a, 0});
            }
            return false;
        }
        if (cnt_a == 0){
            if (len % cnt_b == 0){
                return helper(pattern, value, new int[]{0, len / cnt_b});
            }
            return false;
        }
        for (int la = 0; la <= len / cnt_a; la++){
            int lb;
            if ((len - cnt_a * la) % cnt_b == 0){
                lb = (len - cnt_a * la) / cnt_b;
                if (helper(pattern, value, new int[]{la, lb})){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(String pattern, String value, int[] lab) {
        String[] p = new String[2];
        int i = 0, j = 0;
        while (i < pattern.length()){
            int index = pattern.charAt(i) - 'a';
            if (p[index] == null){
                p[index] = value.substring(j, j + lab[index]);
            }
            int k = 0;
            while (k < p[index].length() && value.charAt(j) == p[index].charAt(k)){
                k++;
                j++;
            }
            if (k < p[index].length()){
                return false;
            }
            i++;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(patternMatching("abba", "dogcatcatdog"));
        System.out.println(patternMatching("abba", "dogcatcatfish"));
        System.out.println(patternMatching("aaaa", "dogcatcatdog"));
        System.out.println(patternMatching("abba", "dogdogdogdog"));
    }
}
