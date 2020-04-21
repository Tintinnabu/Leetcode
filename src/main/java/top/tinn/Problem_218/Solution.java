package top.tinn.Problem_218;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @ClassName Solution
 * @Description
 * 218. 天际线问题
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。
 *
 * Buildings Skyline Contour
 *
 * 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。
 *
 * 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。
 *
 * 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 *
 * 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。
 *
 * 说明:
 *
 * 任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
 * 输入列表已经按左 x 坐标 Li  进行升序排列。
 * 输出列表必须按 x 位排序。
 * 输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 * @Author Tinn
 * @Date 2020/4/21 10:15
 */
public class Solution {
    //o(nlogn)
    public List<List<Integer>> getSkyline1(int[][] buildings) {
        int len = buildings.length;
        if (len < 1) return new ArrayList<>();
        return merge(buildings, 0, len - 1);
    }

    private List<List<Integer>> merge(int[][] buildings, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();
        if (start == end){
            List<Integer> temp = new ArrayList<>();
            temp.add(buildings[start][0]);
            temp.add(buildings[start][2]);
            result.add(temp);
            temp = new ArrayList<>();
            temp.add(buildings[start][1]);
            temp.add(0);
            result.add(temp);
            return result;
        }
        int mid = start + (end - start) / 2;
        //第一组解
        List<List<Integer>> Skyline1  = merge(buildings, start, mid);
        //第二组解
        List<List<Integer>> Skyline2  = merge(buildings, mid + 1, end);
        //合并两组解
        int h1 = 0, h2 = 0, i = 0, j = 0;
        while (i < Skyline1.size() || j <Skyline2.size()){
            long x1 = i < Skyline1.size() ? Skyline1.get(i).get(0) : Long.MAX_VALUE;
            long x2 = j < Skyline2.size() ? Skyline2.get(j).get(0) : Long.MAX_VALUE;
            long x;
            if (x1 < x2){
                h1 = Skyline1.get(i).get(1);
                x = x1;
                i++;
            }else if (x1 > x2){
                h2 = Skyline2.get(j).get(1);
                x = x2;
                j++;
            }else {
                h1 = Skyline1.get(i).get(1);
                h2 = Skyline2.get(j).get(1);
                x = x1;
                i++;
                j++;
            }
            int height = Math.max(h1, h2);
            if (result.isEmpty() || height != result.get(result.size() - 1).get(1)){
                List<Integer> temp = new ArrayList<>();
                temp.add((int)x);
                temp.add(height);
                result.add(temp);
            }
        }
        return result;
    }


    //o(n*n)
    public List<List<Integer>> getSkyline2(int[][] buildings) {
        if (buildings.length < 1) return new ArrayList<>();
        List<List<Integer>> points = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        //求出左上角和右上角坐标, 左上角坐标的 y 存负数
        for (int[] building : buildings){
            List<Integer> p1 = new ArrayList<>();
            p1.add(building[0]);
            p1.add(-building[2]);
            points.add(p1);
            List<Integer> p2 = new ArrayList<>();
            p2.add(building[1]);
            p2.add(building[2]);
            points.add(p2);
        }
        //将所有坐标排序
        /**
         * 考虑两个坐标比较的时候，x 坐标相等会有三种情况。
         *
         * 当两个坐标都是左上角坐标，我们要将高度高的排在前边
         * 当两个坐标都是右上角坐标，我们要将高度低的排在前边
         * 当两个坐标一个是左上角坐标，一个是右上角坐标，我们需要将左上角坐标排在前边
         */
        Collections.sort(points, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> p1, List<Integer> p2) {
                int x1 = p1.get(0);
                int y1 = p1.get(1);
                int x2 = p2.get(0);
                int y2 = p2.get(1);
                if (x1 != x2){
                    return x1 - x2;
                }
                return y1 - y2;
            }
        });
        //默认的优先队列是最小堆，我们需要最大堆，每次需要得到队列中最大的元素
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.offer(0);
        int preMax = 0;
        for (List<Integer> p : points){
            int x = p.get(0);
            int y = p.get(1);
            if (y < 0){
                queue.offer(-y);
            }else{
                queue.remove(y);
            }
            int curMax = queue.peek();
            //最大值更新了, 将当前结果加入
            if (curMax != preMax){
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(curMax);
                result.add(temp);
                preMax = curMax;
            }
        }
        return result;
    }

    //o(nlogn)
    public List<List<Integer>> getSkyline3(int[][] buildings) {
        if (buildings.length < 1) return new ArrayList<>();
        List<List<Integer>> points = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        //求出左上角和右上角坐标, 左上角坐标的 y 存负数
        for (int[] building : buildings){
            List<Integer> p1 = new ArrayList<>();
            p1.add(building[0]);
            p1.add(-building[2]);
            points.add(p1);
            List<Integer> p2 = new ArrayList<>();
            p2.add(building[1]);
            p2.add(building[2]);
            points.add(p2);
        }
        //将所有坐标排序
        /**
         * 考虑两个坐标比较的时候，x 坐标相等会有三种情况。
         *
         * 当两个坐标都是左上角坐标，我们要将高度高的排在前边
         * 当两个坐标都是右上角坐标，我们要将高度低的排在前边
         * 当两个坐标一个是左上角坐标，一个是右上角坐标，我们需要将左上角坐标排在前边
         */
        Collections.sort(points, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> p1, List<Integer> p2) {
                int x1 = p1.get(0);
                int y1 = p1.get(1);
                int x2 = p2.get(0);
                int y2 = p2.get(1);
                if (x1 != x2){
                    return x1 - x2;
                }
                return y1 - y2;
            }
        });
        //K:高度 V:次数
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        treeMap.put(0, 1);
        int preMax = 0;

        for (List<Integer> p : points){
            int x = p.get(0);
            int y = p.get(1);
            if (y < 0){
                treeMap.put(-y, treeMap.getOrDefault(-y,0) + 1);
            }else {
                Integer v = treeMap.get(y);
                if (v == 1) treeMap.remove(y);
                else treeMap.put(y, v - 1);
            }
            int curMax = treeMap.firstKey();
            //最大值更新了, 将当前结果加入
            if (curMax != preMax){
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(curMax);
                result.add(temp);
                preMax = curMax;
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[][] buildings = new int[5][3];
        buildings[0] =new int[]{2,9,10};
        buildings[1] =new int[]{3,7,15};
        buildings[2] =new int[]{5,12,12};
        buildings[3] =new int[]{15,20,10};
        buildings[4] =new int[]{19,24,8};
        System.out.println(getSkyline1(buildings));
        System.out.println(getSkyline2(buildings));
        System.out.println(getSkyline3(buildings));
    }
}
