package top.tinn.GreedyProblem.Problem_738;

public class Solution {
    public int monotoneIncreasingDigits(int N) {
        String s=String.valueOf(N);
        int size=s.length();
        char[] chars=s.toCharArray();
        int mark=0;
        for (int i=size-1;i>=1;i--){
            if (chars[i]<chars[i-1]){
                mark=i;
                chars[i-1]--;
            }
        }
        for (int i=mark;i<size;i++)
            chars[i]='9';
        return Integer.parseInt(new String(chars));
    }
}
