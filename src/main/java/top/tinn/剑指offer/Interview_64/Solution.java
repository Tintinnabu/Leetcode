package top.tinn.剑指offer.Interview_64;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/5 21:33
 */
public class Solution {

    private int ret = 0;

    /**
     * if n > 1, sumNums(n - 1), else ret += 1 and return ret;
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        ret += n;
        return ret;
    }
}
