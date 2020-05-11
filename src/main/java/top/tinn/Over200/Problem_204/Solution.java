package top.tinn.Over200.Problem_204;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/18 20:20
 */
public class Solution {
    public int countPrimes(int n) {
        boolean[] mark = new boolean[n];
        int count = 0;
        for (int i = 2; i * i < n; i++){
            if (!mark[i]){
                for (int j = i * i; j < n; j+=i){
                    mark[j] = true;
                }
            }
        }
        for (int i = 2; i < n; i++){
            if (!mark[i])
                count++;
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(countPrimes(10));
    }
}
