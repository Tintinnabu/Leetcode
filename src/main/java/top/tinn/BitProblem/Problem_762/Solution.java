package top.tinn.BitProblem.Problem_762;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/15 19:22
 */
public class Solution {
    public int countPrimeSetBits(int L, int R) {
        int[] arr = {2,3,5,7,11,13,17,19};
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        int count = 0;
        for (int i = L; i <= R; i++){
            if (set.contains(primeSetBits(i)))
                count++;
        }
        return count;
    }

    private Integer primeSetBits(int i) {
        int bits = 0;
        while (i > 0){
            i &=(i - 1);
            bits++;
        }
        return bits;
    }
}
