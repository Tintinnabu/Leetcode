package top.tinn.剑指offer.Interview_11;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 10:58
 */
public class Solution {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r){
            int mid = l + (r-l)/2;
            if (numbers[mid] < numbers[r]){
                r = mid;
            }else if (numbers[mid] > numbers[r]){
                l = mid + 1;
            }else if (numbers[mid] == numbers[r]){
                r--;
            }
        }
        return numbers[l];
    }
}
