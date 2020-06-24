package top.tinn.Over200.Problem_862;

import java.util.*;

public class Solution {
    public int shortestSubarray(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) -> (a[1]))
        .thenComparing((int[] a) -> (-a[0])));
        int sum = 0;
        int n = A.length;
        int ans = n + 1;
        pq.add(new int[]{0, 0});
        for (int i = 0; i < A.length; i++){
            sum += A[i];
            Iterator<int[]> iterator = pq.iterator();
            while (iterator.hasNext()){
                int[] temp = iterator.next();
                if (sum - temp[1] >= K){
                    ans = Math.min(i - temp[0] + 1, ans);
                }else {
                    break;
                }
            }
            pq.add(new int[]{i + 1, sum});
        }
        return ans == n + 1 ? -1 : ans;
    }
}
