package top.tinn.NowCoder.Tencent_0906.Problem_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/6 20:02
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenA = scanner.nextInt();
        int[] A = new int[lenA];
        for (int i = 0; i < lenA; i++){
            A[i] = scanner.nextInt();
        }
        int lenB = scanner.nextInt();
        int[] B = new int[lenB];
        for (int i = 0; i < lenB; i++){
            B[i] = scanner.nextInt();
        }
        int startA = 0, startB = 0;
        while (startA < lenA && startB < lenB){
            if (A[startA] > B[startB]){
                startA++;
            }else if (A[startA] < B[startB]){
                startB++;
            }else {
                break;
            }
        }
        if (startA == lenA && startB == lenB){
            System.out.println("");
        }
        List<Integer> ans = new ArrayList<>();
        while (startA < lenA && startB < lenB){
            if (A[startA] > B[startB]){
                startA++;
            }else if (A[startA] < B[startB]){
                startB++;
            } else {
                ans.add(A[startA]);
                startA++;
                startB++;
            }
        }

        for (int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }

    }
}
