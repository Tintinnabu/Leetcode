package top.tinn.NowCoder.Guangfa_1014;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/10/14 15:40
 */
public class Solution2 {
    public int getCount (int n) {
        // write code here
        int n2 = n * n;
        int ans = 0;
        int l, r;
        for (int i = 1; i < n; i++){
            if (n2 % i != 0){
                continue;
            }
            r = n2 / i;
            l = i;
            if ((l + r) % 2 == 0 && (r - l) % 2 == 0 && ((r - l) / 2 >= n)){
                //System.out.printf("%d %d %d\n", n, (r - l) / 2, (r + l) / 2);
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        for (int i = 1; i < 20; i++){
            System.out.println(getCount(i));
        }
        System.out.println(getCount(100));
    }
}
