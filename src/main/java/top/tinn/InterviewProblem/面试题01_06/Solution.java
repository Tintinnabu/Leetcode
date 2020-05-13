package top.tinn.InterviewProblem.面试题01_06;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/11 19:34
 */
public class Solution {
    public String compressString(String S) {
        char pre = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++){
            if (count == 0) pre = S.charAt(i);
            if (S.charAt(i) != pre){
                sb.append(pre);
                sb.append(count);
                pre = S.charAt(i);
                count = 1;
            }else {
                count++;
            }
            if (i == S.length() - 1){
                sb.append(pre);
                sb.append(count);
            }
        }
        return S.length() <= sb.length() ? S : sb.toString();
    }
}
