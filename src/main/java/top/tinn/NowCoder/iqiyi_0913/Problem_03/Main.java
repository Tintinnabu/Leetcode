package top.tinn.NowCoder.iqiyi_0913.Problem_03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/13 15:36
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str == null || str.length() == 0){
            System.out.println("");
        }
        int[] array = Arrays.stream(str.split(","))
                .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        int pre = 0;
        for (int i = 0; i <= array.length - 3; i++){
            if (i == 0){
                pre = array[i];
            }else if (pre == array[i]){
                continue;
            }else {
                pre = array[i];
            }
            int target = -array[i];
            int l = i + 1;
            int r = array.length - 1;
            while (l < r){
                //应该先计算，完了再去重
                if (array[l] + array[r] == target){
                    System.out.printf("%d %d %d%n", array[i], array[l], array[r]);
                    while (l < r && array[l] == array[l + 1]){
                        l++;
                    }
                    while(l < r && array[r] == array[r - 1]){
                        r--;
                    }
                    l++;r--;
                }else if (array[l] + array[r] > target){
                    while(l < r && array[r] == array[r - 1]){
                        r--;
                    }
                    r--;
                }else {
                    while (l < r && array[l] == array[l + 1]){
                        l++;
                    }
                    l++;
                }
            }

        }
    }
}
