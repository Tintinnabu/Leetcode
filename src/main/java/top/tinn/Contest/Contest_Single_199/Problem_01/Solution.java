package top.tinn.Contest.Contest_Single_199.Problem_01;

public class Solution {
    public String restoreString(String s, int[] indices) {
        char[] sChar = new char[indices.length];
        for (int i = 0; i < indices.length; i++){
            sChar[indices[i]] = s.charAt(i);
        }
        return String.valueOf(sChar);
    }
}
