package top.tinn.Over200.Problem_771;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 20:50
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0){
            return 0;
        }
        boolean[] j = new boolean[256];
        for (char c : J.toCharArray()){
            j[c] = true;
        }
        int count = 0;
        for (char c : S.toCharArray()){
            if (j[c]){
                count++;
            }
        }
        return count;
    }
}
