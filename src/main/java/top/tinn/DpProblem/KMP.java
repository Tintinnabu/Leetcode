package top.tinn.DpProblem;

public class KMP {
    private int[][] dp;
    private String pat;

    /**
     * dp[j][c] = next
     * 0 <= j < M，代表当前的状态
     * 0 <= c < 256，代表遇到的字符（ASCII 码）
     * 0 <= next <= M，代表下一个状态
     *
     * dp[4]['A'] = 3 表示：
     * 当前是状态 4，如果遇到字符 A，
     * pat 应该转移到状态 3
     *
     * dp[1]['B'] = 2 表示：
     * 当前是状态 1，如果遇到字符 B，
     * pat 应该转移到状态 2
     * @param pat
     */

    public KMP(String pat) {
        this.pat = pat;
        // 通过 pat 构建 dp 数组
        // 需要 O(M) 时间
        int M=pat.length();
        // dp[状态][字符] = 下个状态
        dp=new int[M][256];
        dp[0][pat.charAt(0)]=1;
        // 影子状态 X 初始为 0
        int X=0;
        // 当前状态 j 从 1 开始
        for (int j=1;j<M;j++){
            for (int c=0;c<256;c++){
                if (pat.charAt(j)==c)
                    dp[j][c]=j+1;
                else dp[j][c]=dp[X][c];
            }
            // 更新影子状态
            X=dp[X][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        // 借助 dp 数组去匹配 txt
        // 需要 O(N) 时间
        int M=pat.length();
        int N=txt.length();
        // pat 的初始态为 0
        int j=0;
        for (int i=0;i<N;i++){
            //状态转移
            j=dp[j][txt.charAt(i)];
            if (j==M) return i-M+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP("aaab");
        int pos1 = kmp.search("aaacaaab"); //4
        int pos2 = kmp.search("aaaaaaab"); //4
        System.out.println(pos1);
        System.out.println(pos2);
    }
}
