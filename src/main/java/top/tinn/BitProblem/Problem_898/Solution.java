package top.tinn.BitProblem.Problem_898;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/15 21:15
 */
public class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);
        for (int x : A){
            Set<Integer> cur2 = new HashSet<>();
            for (int y : cur)
                cur2.add(x | y);
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }
        return ans.size();
    }

    @Test
    public void test(){
        System.out.println(subarrayBitwiseORs(new int[]{1,1,2}));
    }
}
