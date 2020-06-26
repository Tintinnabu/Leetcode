package top.tinn.Over200.Problem_1111;

public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] res = new int[len];
        int depth = 0;
        char[] chars = seq.toCharArray();
        for (int i = 0; i < len; i++){
            if (chars[i] == '('){
                depth++;
                res[i] = depth % 2;
            } else {
                res[i] = depth % 2;
                depth--;
            }
        }
        return res;
    }
}
