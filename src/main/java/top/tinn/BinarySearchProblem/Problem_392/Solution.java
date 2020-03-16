package top.tinn.BinarySearchProblem.Problem_392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int index=-1;
        for (char c:s.toCharArray()){
            index=t.indexOf(c,index+1);
            if (index==-1) return false;
        }
        return true;
    }
}
