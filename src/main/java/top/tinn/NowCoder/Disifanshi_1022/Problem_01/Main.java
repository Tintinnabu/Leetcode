package top.tinn.NowCoder.Disifanshi_1022.Problem_01;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/22 19:02
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        //initial finish
        System.out.println(Top4(arr, 0, arr.length - 1));
    }

    private static int Top4(int[] arr, int i, int j) {
        int l = i, r = j, k = i;
        int pivot = arr[(i + j) >> 1];
        while (k <= r){
            if (arr[k] < pivot){
                swap(arr, k, l);
                l++;
                k++;
            }else if (arr[k] > pivot){
                swap(arr, k, r);
                r--;
            }else {
                k++;
            }
        }
        int temp = arr.length - 4;
        if (l <= temp && temp <= r){
            return pivot;
        }else if (l > temp){
            return Top4(arr, i, l - 1);
        }
        return Top4(arr, r + 1, j);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
