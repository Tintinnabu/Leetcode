package top.tinn.Contest.Contest_Single_198.Problem_01;

public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;
        while (empty >= numExchange){
            ans += empty / numExchange;
            empty = empty / numExchange + empty % numExchange;
        }
        return ans;
    }
}
