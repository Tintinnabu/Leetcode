package top.tinn.Over200.Problem_1024;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Tinn
 * @Date: 2020/10/24 10:47
 */
public class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] mark = new int[T + 1];
        for (int[] clip : clips){
            int from = clip[0];
            int to = clip[1];
            if (from > T){
                continue;
            }
            if (mark[from] < to){
                mark[from] = Math.min(to, T);
            }
        }
        int i = 0;
        int ans = 0;
        while (i < T){
            int to = mark[i];
            if (to >= T){
                return ans + 1;
            }
            int next = i;
            int cur = i;
            for (int j = i; j <= to; j++){
                if (mark[j] > cur){
                    cur = mark[j];
                    next = j;
                }
            }
            if (next == i) return -1;
            ans++;
            i = next;
        }
        return ans;
    }

    @Test
    public void test(){
        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int T = 10;
        System.out.println(videoStitching(clips, T));
    }
}
