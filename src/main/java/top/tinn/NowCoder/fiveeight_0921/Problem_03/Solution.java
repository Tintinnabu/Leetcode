package top.tinn.NowCoder.fiveeight_0921.Problem_03;

import java.util.ArrayList;

/**
 * @Author: Tinn
 * @Date: 2020/9/21 20:27
 */
public class Solution {
    /**
     * 合并数组
     * @param arrayA int整型ArrayList 数组A
     * @param arrayB int整型ArrayList 数组B
     * @return int整型ArrayList
     */
    public ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        // write code here
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < arrayA.size() && j < arrayB.size()){
            int curA = arrayA.get(i);
            int curB = arrayB.get(j);
            if (curA == curB){
                ans.add(curA);
                i++;
                j++;
            }else if (curA < curB){
                i++;
            }else {
                j++;
            }
        }
        return ans;
    }
}
