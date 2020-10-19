package top.tinn.NowCoder.Ebay_1016;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/10/16 19:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            list.add(new Node(a, b, c));
        }
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.start == o2.start){
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        int cur = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        List<Integer> ans = new ArrayList<>();
        Node node;
        for (int i = 1; i <= n; i++){
            while (j < list.size() && list.get(j).start == i){
                node = list.get(j++);
                cur += node.val;
                map.put(node.end + 1, map.getOrDefault(node.end + 1, 0) + node.val);
            }
            if (map.containsKey(i)){
                cur -= map.get(i);
            }
            ans.add(cur);
        }
        for (int i = 0; i < n; i++){
            System.out.printf("%d ", ans.get(i));
        }
    }

    static class Node{
        int start;
        int end;
        int val;

        public Node(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
}
