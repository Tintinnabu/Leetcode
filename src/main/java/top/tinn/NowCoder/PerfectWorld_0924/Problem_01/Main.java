package top.tinn.NowCoder.PerfectWorld_0924.Problem_01;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/9/24 19:57
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //建筑物个数
        int n = Integer.parseInt(sc.nextLine());
        int[][] buildings = new int[n][3];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            for (int j = 0; j < arr.length; j++) {
                buildings[i][j] = Integer.parseInt(arr[j]);
            }
        }
        Arrays.sort(buildings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        //获取天际线，待实现
        List<List<Integer>> skyline = getSkyline(buildings);

        //输出skyline到标准输出
        for (List<Integer> point : skyline) {
            int size = point.size();
            for (int i = 0; i < size; i++) {
                System.out.print(point.get(i));
                if (i < size-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        //todo 实现算法
        List<int[]> record = new ArrayList<>();
        for (int[] building : buildings) {
            record.add(new int[]{building[0], building[2]});
            record.add(new int[]{building[1], building[2]});
        }
        Collections.sort(record, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.add(0);
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] r : record){
            if (r[1] > pq.peek()){
                pq.add(r[1]);
                List<Integer> temp = new ArrayList<>();
                temp.add(r[0]);
                temp.add(pq.peek());
                ans.add(temp);
            }else if (r[1] == pq.peek()){
                pq.poll();
                List<Integer> temp = new ArrayList<>();
                temp.add(r[0]);
                temp.add(pq.peek());
                ans.add(temp);
            }else {
                if (pq.contains(r[1])){
                    pq.remove(r[1]);
                }else {
                    pq.add(r[1]);
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++){
            if (i == 0){
                ret.add(ans.get(i));
            }
            while (i < ans.size() && ans.get(i).get(0).equals(ans.get(i - 1).get(0))){
                i++;
            }
            ret.add(ans.get(i));

        }
        return ans;
    }
}
