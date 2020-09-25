package top.tinn.NowCoder.Huawei_0923.Problem_03;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Tinn
 * @Date: 2020/9/23 20:04
 */
public class Main2 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //initial
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int numOfShops = scanner.nextInt();
        int[][] shop = new int[numOfShops][2];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < numOfShops; i++){
            for (int j = 0; j < 2; j++){
                shop[i][j] = scanner.nextInt();
            }
        }
        int numOfZ = scanner.nextInt();
        int[][] Z = new int[numOfZ][2];
        for (int i = 0; i < numOfZ; i++){
            for (int j = 0; j < 2; j++){
                Z[i][j] = scanner.nextInt();
            }
        }
        int numOfCustomer = scanner.nextInt();
        int[][] customer = new int[numOfCustomer][2];
        for (int i = 0; i < numOfCustomer; i++){
            for (int j = 0; j < 2; j++){
                customer[i][j] = scanner.nextInt();
            }
        }
        //initial finish
        Set<Node> reached = new HashSet<>();
        Set<Node> customers = new HashSet<>();
        for (int i = 0; i < numOfCustomer; i++){
            customers.add(new Node(customer[i][0], customer[i][1]));
        }
        for (int i = 0; i < numOfShops; i++){
            reached.add(new Node(shop[i][0], shop[i][1]));
            visited[shop[i][0]][shop[i][1]] = true;
        }
        int path = 0;
        int ans = 0;
        Set<Node> newReached ;
        Set<Node> newCostomers;
        while (reached.size() != 0){
            newReached = new HashSet<>();
            newCostomers = new HashSet<>();
            for (Node r : reached){
                visited[r.i][r.j] = true;
                for (int i = 0; i < 4; i++){
                    int newI = r.i + dx[i];
                    int newJ = r.j + dy[i];
                    if (newI >= 0 && newI < n && newJ >= 0 && newJ < m
                            &&!visited[newI][newJ]){
                        newReached.add(new Node(newI, newJ));
                    }
                }
            }
            path++;
            if (customers.size() == 0){
                break;
            }
            for (Node c : customers){
                if (newReached.contains(c)){
                    ans += path;
                }else {
                    newCostomers.add(c);
                }
            }
            customers = newCostomers;
            reached = newReached;
        }
        System.out.println(ans * 2);
    }


    static class Node{
        int i;
        int j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(i) ^ Integer.hashCode(j);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null){
                return false;
            }
            if (this == obj){
                return true;
            }
            if (obj instanceof Node){
                Node n = (Node)obj;
                return n.i == i && n.j == i;
            }else {
                return false;
            }
        }
    }
}
