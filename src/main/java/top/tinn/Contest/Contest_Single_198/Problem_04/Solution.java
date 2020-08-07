package top.tinn.Contest.Contest_Single_198.Problem_04;

public class Solution {
    public int closestToTarget(int[] arr, int target) {
        int res = Math.abs(arr[0] - target);
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i] & arr[i - 1];
            if (Math.abs(arr[i] - target) < res){
                res = Math.abs(arr[i] - target);
            }
            if (Math.abs(temp - target) < res){
                res = Math.abs(temp - target);
                arr[i] = temp;
            }
        }
        return res;
    }
}
