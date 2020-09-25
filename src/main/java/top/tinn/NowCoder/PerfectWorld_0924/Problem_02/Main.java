package top.tinn.NowCoder.PerfectWorld_0924.Problem_02;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/24 19:27
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        int result = search(nums, target);

        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
//todo 实现算法
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]){
                if (nums[mid] > target){
                    r = mid - 1;
                }else if (nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }else if (nums[mid] < target && target >= nums[l]){
                    r = mid - 1;
                }else {
                    r = mid;
                }
            }else if (nums[mid] > nums[r]){
                if (nums[mid] > target && target >= nums[l]){
                    r = mid - 1;
                }else if (nums[mid] > target && target <= nums[r]){
                    l = mid + 1;
                }else if (nums[mid] < target){
                    l = mid + 1;
                }else {
                    r = mid;
                }
            }else {
                r = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
