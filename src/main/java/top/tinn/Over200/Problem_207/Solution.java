package top.tinn.Over200.Problem_207;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 207. 课程表
 *
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees=new int[numCourses];
        for(int[] cp:prerequisites) indegrees[cp[0]]++;
        LinkedList<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0) queue.addLast(i);
        }
        while (!queue.isEmpty()){
            Integer pre=queue.removeFirst();
            numCourses--;
            for(int[] req:prerequisites){
                if(req[1]==pre){
                    if(--indegrees[req[0]]==0)
                        queue.addLast(req[0]);
                }
            }
        }
        return numCourses==0;
    }


    //DFS
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        // dfs进行判断是否有环
        // 新建邻接表
        List<List<Integer>> adjacency = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; ++i) {
            adjacency.add(new ArrayList<>());
        }

        // 初始化状态节点
        int[] flags = new int[numCourses];

        // 初始邻接表
        for (int[] course : prerequisites) {
            adjacency.get(course[1]).add(course[0]);
        }

        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(List<List<Integer>> adjacency, int[] flags, int cur) {
        if (flags[cur] == 1) {
            // 碰到正在遍历的节点 有环
            return false;
        }

        if (flags[cur] == -1) {
            // 碰到遍历过的节点
            return true;
        }

        // 设置为正在遍历
        flags[cur] = 1;

        // dfs邻接节点
        for (Integer next : adjacency.get(cur)) {
            if (!dfs(adjacency, flags, next)) {
                return false;
            }
        }

        // 设置为遍历完
        flags[cur] = -1;

        // 可以顺利遍历完
        return true;
    }

    @Test
    public void test(){
        int numCourses = 4;
        int[][] prerequisites = new int[4][2];
        prerequisites[0] = new int[]{1,0};
        prerequisites[1] = new int[]{2,0};
        prerequisites[2] = new int[]{3,1};
        prerequisites[3] = new int[]{3,2};
        canFinish2(numCourses, prerequisites);
    }

}
