package top.tinn.Over200.Problem_1021;

public class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for (char c : S.toCharArray()){
            if (c == '('){
                if (depth > 0){
                    sb.append(c);
                }
                depth++;
            }else {
                if (depth > 1){
                    sb.append(c);
                }
                depth--;
            }
        }
        return sb.toString();
    }
}
