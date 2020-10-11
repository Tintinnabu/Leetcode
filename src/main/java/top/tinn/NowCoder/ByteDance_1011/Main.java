package top.tinn.NowCoder.ByteDance_1011;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/10/11 13:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++){
            int key = scanner.nextInt();
            int val = scanner.nextInt();
            map.put(key, map.getOrDefault(key, 0) + val);
        }
        for (int key : map.keySet()){
            list.add(new int[]{key, map.get(key)});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < M; i++){
            System.out.printf("%d ", list.get(i)[0]);
        }
    }
}
