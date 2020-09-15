package top.tinn.NowCoder.iqiyi_0913.Problem_02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/13 15:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        int num = 1;
        int pre = array[0];
        for (int i = 1; i < array.length; i++){
            if (pre != array[i]){
                if (--num < 0){
                    pre = array[i];
                }
            }else {
                num++;
            }
        }
        System.out.println(pre);
    }
}
