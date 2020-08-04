package top.tinn.Contest.Contest_Single_200.Problem_01;

public class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        if (arr.length < 3){
            return 0;
        }
        int count = 0;
        for (int l = 0; l <= arr.length - 3; l++){
            for (int m = l + 1; m <= arr.length - 2; m++){
                for (int r = m + 1; r < arr.length; r++){
                    if (Math.abs(arr[l] - arr[m]) <= a && Math.abs(arr[m] - arr[r]) <= b && Math.abs(arr[l] - arr[r]) <= c) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
}
