package top.tinn.BinarySearchProblem.Problem_875;

import org.junit.jupiter.api.Test;

public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int sum = 0;
        int max = 0;
        for (int pile : piles){
            max = Math.max(max, pile);
            sum += pile;
        }
        int min = sum / H;
        if (sum % H != 0){
            min++;
        }
        int l = min, r = max;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (!eatingTimes(piles, mid, H)){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    private boolean eatingTimes(int[] piles, int speed, int H){
        int time = 0;
        for (int pile : piles){
            time += pile / speed;
            if (pile % speed != 0){
                time ++;
            }
            if (time > H){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}
