package top.tinn.Problem_210;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/20 13:32
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees=new int[numCourses],res = new int[numCourses];
        for(int[] cp:prerequisites) indegrees[cp[0]]++;
        LinkedList<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0) queue.addLast(i);
        }
        int i = 0;
        while (!queue.isEmpty()){
            Integer pre=queue.removeFirst();
            res[i++] = pre;
            for(int[] req:prerequisites){
                if(req[1]==pre){
                    if(--indegrees[req[0]]==0)
                        queue.addLast(req[0]);
                }
            }
        }
        return i != numCourses ? new int[0] : res;
    }

    @Test
    public void test(){
        int numCourses = 4;
        int[][] prerequisites = new int[4][2];
        prerequisites[0] = new int[]{1,0};
        prerequisites[1] = new int[]{0,1};
        prerequisites[2] = new int[]{3,1};
        prerequisites[3] = new int[]{3,2};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
}
