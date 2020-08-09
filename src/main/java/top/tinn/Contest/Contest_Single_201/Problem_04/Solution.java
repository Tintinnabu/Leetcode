package top.tinn.Contest.Contest_Single_201.Problem_04;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {
    private int res = 0;
    public int minCost(int n, int[] cuts) {
        res = 0;
        List<Integer> position = new ArrayList<>();
        for (int cut : cuts){
            position.add(cut);
        }
        helper(0, n, position);
        return res;
    }

    private void helper(int left, int right, List<Integer> position) {
        if (position.isEmpty()){
            return;
        }
        if (position.size() == 1 ){
            if (position.get(0) >= left && position.get(0) <= right){
                res += right - left;
                position.clear();
            }
            return;
        }
        int diff = right - left;
        int midIndex;
        if (diff % 2 == 0){
            midIndex = findMiddllestValue(left + diff / 2, position);

        }else {
            int midIndex1 = findMiddllestValue(left + diff / 2, position);
            int midIndex2 = findMiddllestValue(left + diff / 2 + 1, position);
            midIndex = Math.abs(position.get(midIndex1) - (left + diff / 2)) <=
                    Math.abs(position.get(midIndex2) - (left + diff / 2 + 1)) ? midIndex1 : midIndex2;
        }
        int midValue = position.get(midIndex);
        position.remove(midIndex);
        res += right - left;
        helper(left, midValue, position);
        helper(midValue, right, position);
    }

    private int findMiddllestValue(int target, List<Integer> position) {
        int distance = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < position.size(); i++){
            if (Math.abs(position.get(i) - target) < distance){
                res = i;
                distance = Math.abs(position.get(i) - target);
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] cuts = {1,3,4,5};
        int n = 7;
        System.out.println(minCost(n, cuts));
    }
}
