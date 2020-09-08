package top.tinn.NowCoder.Tencent_0906.Problem_04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/6 20:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
            arr2[i] = arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++){
            int index = findIndexInArr(arr2[i], arr);
            if (index < n / 2){
                System.out.println(arr[(n + 1) / 2]);
            }else {
                System.out.println(arr[(n - 1) / 2]);
            }
        }
    }

    private static int findIndexInArr(int a, int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (arr[mid] == a){
                return mid;
            }else if (arr[mid] > a){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}
