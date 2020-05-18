package top.tinn.InterviewProblem.面试题01_01;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/11 19:34
 */
public class Solution {
    public boolean isUnique(String astr) {
        int mark = 0;
        for (char c : astr.toCharArray()){
            if ((mark & (1 << (c - 'a'))) != 0){
                return false;
            }
            mark |= (1 << (c - 'a'));
        }
        return true;
    }
}
