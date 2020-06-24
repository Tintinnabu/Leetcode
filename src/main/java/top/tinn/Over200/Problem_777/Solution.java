package top.tinn.Over200.Problem_777;

public class Solution {
    public boolean canTransform(String start, String end) {
        int i = 0, j = 0;
        while (i < start.length() && j < end.length()){
            while (i < start.length() && start.charAt(i) == 'X'){
                i++;
            }
            while (j < end.length() && end.charAt(j) == 'X'){
                j++;
            }
            if (i < start.length() ^ j < end.length()){
                return false;
            }else if (i == start.length() && j == end.length()){
                return true;
            }else {
                if (start.charAt(i) != end.charAt(j) ||
                        (start.charAt(i) == 'L' && i < j) ||
                        (start.charAt(i) == 'R' && i > j)){
                    return false;
                }
            }
            i++;
            j++;
        }
        while (i < start.length() && start.charAt(i) == 'X'){
            i++;
        }
        while (j < end.length() && end.charAt(j) == 'X'){
            j++;
        }
        return i == start.length() && j == end.length();
    }
}
