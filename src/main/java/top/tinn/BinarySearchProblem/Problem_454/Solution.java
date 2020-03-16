package top.tinn.BinarySearchProblem.Problem_454;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len=A.length;
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                int temp=A[i]+B[j];
                map1.put(temp,map1.getOrDefault(temp,0)+1);
            }
        }
        int count=0;
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                int temp=C[i]+D[j];
                if (map1.containsKey(-temp))
                    count+=map1.get(-temp);
            }
        }
        return count;
    }

    @Test
    public void test(){
        int[] A={0,1,-1};
        int[] B={-1,1,0};
        int[] C={0,0,1};
        int[] D={-1,1,1};
        System.out.println(fourSumCount(A,B,C,D));
    }
}
