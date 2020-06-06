package top.tinn.Over200.Problem_621;

import java.util.Arrays;

/**
 * 621. 任务调度器
 *
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * 示例 1：
 *
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 注：
 *
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 解题思路：
     * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     * 2、对数组进行排序，优先排列个数（count）最大的任务，
     *      如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
     * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
     *      则retCount++ ==> A->B->X->A->B->X->A->B
     * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
     *
     * @param tasks
     * @param n
     * @return
     */

    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        for (char c:tasks) count[c-'a']++;
        Arrays.sort(count);
        int maxVal=count[25]-1;
        int idleSpace=maxVal*n;
        for (int i=24;count[i]>0;i--){
            idleSpace-=Math.min(count[i],maxVal);
        }
        /**
         * 在将所有的任务安排完成后，如果仍然有剩余的空闲时间，
         * 那么答案即为（任务的总数 + 剩余的空闲时间）；
         * 如果在安排某一个任务时，遇到了剩余的空闲时间不够的情况，
         * 那么答案一定就等于任务的总数。这是因为我们可以将空闲时间增加虚拟的一列，
         * 继续安排任务。如果不考虑这些虚拟的列，
         * 在原本空闲时间对应的那些列中的任务是可以按照要求顺序执行的，
         * 而增加了这些虚拟的列后，两个相邻的相同任务的间隔不可能减少，
         * 并且虚拟的列中的任务也满足冷却时间的要求，
         * 因此仍然顺序执行并跳过虚拟的列中剩余的“空闲时间”一定是可行的。
         *
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        return idleSpace>0?idleSpace+tasks.length:tasks.length;
    }
}

