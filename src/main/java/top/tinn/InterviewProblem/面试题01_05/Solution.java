package top.tinn.InterviewProblem.面试题01_05;

import org.junit.jupiter.api.Test;

public class Solution {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (len1 * len2 == 0 ){
            return len1 + len2 < 2;
        }
        if (len1 == len2){
            int i = 0;
            boolean replace = false;
            while (i < len1){
                if (first.charAt(i) != second.charAt(i)){
                    if (replace){
                        return false;
                    }else {
                        replace = true;
                    }
                }
                i++;
            }
            return true;
        }else if (len1 - len2 == 1){
            int i = 0, j = 0;
            boolean remove = false;
            while (i < len1 && j < len2){
                if (first.charAt(i) != second.charAt(j)){
                    if (remove){
                        return false;
                    }
                    remove = true;
                }else{
                    j++;
                }
                i++;
            }
            return true;
        }else if (len1 - len2 == -1){
            return oneEditAway(second, first);
        }else {
            return false;
        }
    }

    public boolean oneEditAway2(String first, String second) {
        int deltaLen = first.length() - second.length();
        if (deltaLen > 1 || deltaLen < -1){
            return false;
        }
        boolean chance = true;
        for (int i = 0, j = 0; i < first.length() && j < second.length(); i++, j++){
            if (first.charAt(i) != second.charAt(j)){
                if (!chance){
                    return false;
                }
                if (deltaLen == 1){
                    j--;
                }else if (deltaLen == -1){
                    i--;
                }
                chance = false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        String first = "a";
        String second = "ab";
        System.out.println(oneEditAway2(first, second));
    }
}
