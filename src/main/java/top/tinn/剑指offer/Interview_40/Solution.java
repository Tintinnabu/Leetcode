package top.tinn.剑指offer.Interview_40;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/1 16:32
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int left, int right, int target){
        if (left >= right) return;
        Random random = new Random();
        int pivot = random.nextInt(right - left) + left;
        int pivotVal = arr[pivot];
        int i = left, j = right, k = left;
        while (k <= j){
            if (arr[k] < pivotVal){
                swap(arr, i, k);
                i++;k++;
            }else if (arr[k] > pivotVal){
                swap(arr, k, j);
                j--;
            }else {
                k++;
            }
        }
        if (target < i)
            quickSort(arr, left, i - 1, target);
        else if (target <= j) return ;
        else  quickSort(arr, j + 1, right, target);
    }

    private void swap(int[] arr, int i, int k) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}
