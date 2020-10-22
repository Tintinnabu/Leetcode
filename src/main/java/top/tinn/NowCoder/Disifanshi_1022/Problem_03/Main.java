package top.tinn.NowCoder.Disifanshi_1022.Problem_03;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/10/22 19:33
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = scanner.nextInt();
        }
        int[] nextPosition = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = N - 1; i >= 0; i--){
            nextPosition[i] = map.getOrDefault(arr[i], N + 1);
            map.put(arr[i], i);
        }
        Set<Integer> cache = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < N; i++){
            if (cache.size() < K){
                if (!contains(cache, arr, i)){
                    cache.add(i);
                    ans++;
                }
            } else {
                if (!contains(cache, arr, i)){
                    cache.remove(maxDistance(cache, nextPosition));
                    ans++;
                    cache.add(i);
                }
            }
        }
        System.out.println(ans);
    }

    private static int maxDistance(Set<Integer> cache, int[] nextPosition) {
        int i = -1;
        int distance = -1;
        for (int index : cache){
            if (i == -1){
                i = index;
                distance = nextPosition[i];
            }else {
                if (nextPosition[index] > distance){
                    distance = nextPosition[index];
                    i = index;
                }
            }
        }
        return i;
    }

    private static boolean contains(Set<Integer> cache, int[] arr, int i) {
        for (int index : cache){
            if (arr[index] == arr[i]){
                return true;
            }
        }
        return false;
    }
}
