package top.tinn.Contest.Contest_Single_191.Problem_03;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/31 10:26
 */
public class Solution {
    Set<Integer> target = new HashSet<>();
    public int minReorder(int n, int[][] connections) {
        int ret = 0;
        target.add(0);
        while (target.size() < n){
            addTarget(connections);
            for (int [] conn : connections){
                if (target.contains(conn[0]) && !target.contains(conn[1])){
                    target.add(conn[1]);
                    ret++;
                }
            }
        }
        return ret;
    }

    private void addTarget(int[][] connections){
        for (int [] conn : connections){
            if (target.contains(conn[1])){
                target.add(conn[0]);

            }
        }
    }

    @Test
    public void test(){
        int n = 6;
        int[][] conn = new int[5][2];
        conn[0] = new int[]{0,1};
        conn[1] = new int[]{1,3};
        conn[2] = new int[]{2,3};
        conn[3] = new int[]{4,0};
        conn[4] = new int[]{4,5};
        System.out.println(minReorder(n, conn));
    }
}
