package top.tinn.DpProblem.Problem_887;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 887. 鸡蛋掉落
 *
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 *
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 *
 * 输入：K = 3, N = 14
 * 输出：4
 *  
 *
 * 提示：
 *
 * 1 <= K <= 100
 * 1 <= N <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    private Map<Integer,Integer> memo=new HashMap<>();
    public int superEggDrop(int K, int N) {
        return dp2(K,N);
    }

    //K*N*N
    private int dp(int K, int N) {
        if (!memo.containsKey(N*100+K)){
            int ans;
            if (N==0) ans=0;
            else if (K==1) ans=N;
            else {
                ans=Integer.MAX_VALUE;
                for (int i=1;i<=N;i++){
                    ans=Math.min(ans,Math.max(dp(K-1,i-1),dp(K,N-i))+1);
                }
                memo.put(N*100+K,ans);
            }
            return ans;
        }
        return memo.get(N*100+K);
    }

    //K*N*logN
    private int dp2(int K, int N) {
        if (!memo.containsKey(N*100+K)){
            int ans;
            if (N==0) ans=0;
            else if (K==1) ans=N;
            else {
                ans=Integer.MAX_VALUE;
                int l=1,r=N;
                while (l<=r){
                    int mid=l+(r-l)/2;
                    int broken=dp2(K-1,mid-1);
                    int unBroken=dp2(K,N-mid);
                    if (broken>unBroken){
                        r=mid-1;
                        ans=Math.min(ans,broken+1);
                    }else {
                        l=mid+1;
                        ans=Math.min(ans,unBroken+1);
                    }
                }
                memo.put(100*N+K,ans);
            }
            return ans;
        }
        return memo.get(N*100+K);
    }

    //dp[k][m] = n
    //# 当前有 k 个鸡蛋，可以尝试扔 m 次鸡蛋
    //# 这个状态下，最坏情况下最多能确切测试一栋 n 层的楼
    //
    //# 比如说 dp[1][7] = 7 表示：
    //# 现在有 1 个鸡蛋，允许你扔 7 次;
    //# 这个状态下最多给你 7 层楼，
    //# 使得你可以确定楼层 F 使得鸡蛋恰好摔不碎
    //# （一层一层线性探查嘛）

    /**
     * 1、无论你在哪层楼扔鸡蛋，鸡蛋只可能摔碎或者没摔碎，碎了的话就测楼下，没碎的话就测楼上。
     * 2、无论你上楼还是下楼，总的楼层数 = 楼上的楼层数 + 楼下的楼层数 + 1（当前这层楼）。
     * 根据这个特点，可以写出下面的状态转移方程：
     * dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1
     * dp[k][m - 1] 就是楼上的楼层数，因为鸡蛋个数 k 不变，也就是鸡蛋没碎，扔鸡蛋次数 m 减一；
     * dp[k - 1][m - 1] 就是楼下的楼层数，因为鸡蛋个数 k 减一，也就是鸡蛋碎了，同时扔鸡蛋次数 m 减一。
     * @param K
     * @param N
     * @return
     */
    //K*N
    public int superEggDrop2(int K, int N) {
        int[][] dp=new int[K+1][N+1];
        int m=0;
        while (dp[K][m]<N){
            m++;
            for (int k=1;k<=K;k++){
                dp[k][m]=dp[k][m-1]+1+dp[k-1][m-1];
            }
        }
        return m;
    }

    //
    public int superEggDrop3(int K, int N) {
        int[][] dp=new int[K+1][N+1];
        int m=0;
        int lo = 1, hi = N;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            for (int k=1;k<=K;k++){
                dp[k][m]=dp[k][m-1]+1+dp[k-1][m-1];
            }
            if (dp[K][mid] < N) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return m;



    }


    @Test
    public void test(){
        System.out.println(superEggDrop2(3,14));
    }
}
