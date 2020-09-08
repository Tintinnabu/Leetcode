package top.tinn.NowCoder.Tencent_0906.Problem_03;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/9/6 20:52
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++){
            String temp = scanner.next();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        List<Node> little = new ArrayList<>();
        List<Node> big = new ArrayList<>();
        for (String key : map.keySet()){
            int count = map.get(key);
            Node node = new Node(key, count);
            little.add(node);
            big.add(node);
        }
        Collections.sort(little, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.count == o2.count){
                    return o1.val.compareTo(o2.val);
                }
                return o1.count - o2.count;
            }
        });
        Collections.sort(big, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.count == o2.count){
                    return o1.val.compareTo(o2.val);
                }
                return o2.count - o1.count;
            }
        });
        for (int i = 0; i < K; i++){
            System.out.printf("%s %d", big.get(i).val, big.get(i).count);
            System.out.println();
        }
        for (int i = 0; i < K; i++){
            System.out.printf("%s %d", little.get(i).val, little.get(i).count);
            System.out.println();
        }
    }

    static class Node{
        String val;
        int count;

        public Node(String val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
