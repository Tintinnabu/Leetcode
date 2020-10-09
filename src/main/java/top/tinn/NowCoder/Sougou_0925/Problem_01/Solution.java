package top.tinn.NowCoder.Sougou_0925.Problem_01;

/**
 * @Author: Tinn
 * @Date: 2020/9/25 19:05
 */


public class Solution {
    public Interval solve (int n, int k, String str1, String str2) {
        // write code here
        if (n == k){
            return new Interval(n, n);
        }
        int same = 0, different = 0;
        for (int i = 0; i < n; i++){
            if (str1.charAt(i) == str2.charAt(i)){
                same++;
            }else{
                different++;
            }
        }
        int start = 0, end = 0;
        if (same >= k){
            start = 0;
            end = k;
        }else {
            start = Math.max(0, k - different);
            end = same + n - k;
        }
        return new Interval(start, end);
    }

      public class Interval {
        int start;
        int end;

          public Interval(int start, int end) {
              this.start = start;
              this.end = end;
          }
      }
}
