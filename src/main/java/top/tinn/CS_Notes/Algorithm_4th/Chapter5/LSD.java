package top.tinn.CS_Notes.Algorithm_4th.Chapter5;

import java.util.Arrays;

/**
 * @ClassName LSD
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/24 18:00
 */
public class LSD {
    public static void sort(String[] a, int W){
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = W - 1; d >=0; d--){
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++){
                count[a[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++){
                count[r + 1] += count[r];
            }
            for (int i = 0; i < N; i++){
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++){
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"1a","1b","2a","2b"};
        LSD.sort(a, 2);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
    }
}
