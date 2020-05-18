package top.tinn.DpProblem.Problem_010;

public class Solution {
    public boolean isMatch(String s,String p){
        if(s==null||p==null) return false;
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for (int i=0;i<p.length();i++){
            if (p.charAt(i)=='*'&&dp[0][i-1])
                dp[0][i+1]=true;
        }
        for (int i=0;i<s.length();i++){
            for (int j=0;j<p.length();j++){
                if (p.charAt(j)=='.'||p.charAt(j)==s.charAt(i)) dp[i+1][j+1]=dp[i][j];
                if (p.charAt(j)=='*'){
                    if (p.charAt(j-1)!=s.charAt(i)&&p.charAt(j-1)!='.')
                        dp[i+1][j+1]=dp[i+1][j-1];
                    else dp[i+1][j+1]=dp[i+1][j-1]||dp[i+1][j]||dp[i][j+1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    /**
     * 设动态规划网格 dpdp，dp[i][j] 代表字符串 s 中前 i个字符和 p 中前 j 个字符是否匹配，值为 truetrue 或 false
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s,String p){
        int ls = s.length(), lp = p.length();
        boolean[][] dp = new boolean[ls + 1][lp + 1];
        dp[0][0] = true;
        //j从2开始时因为*不可能出现在第一位
        for (int j = 2; j <= lp; j++){
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        for (int i = 1; i <= ls; i++){
            for (int j = 1; j <= lp; j++){
                int m = i - 1, n = j - 1;
                if (p.charAt(n) == '*'){
                    //此两种情况代表 s[m]s[m] 和 p[n-1]p[n−1] 可以匹配，等价于无 s[m]s[m] 的状态 dp[i-1][j]dp[i−1][j]；
                    //Tips: 此情况代表 s[m]s[m] 和 p[n-1]p[n−1] 无法匹配，p[n-1]p[n−1] p[n]p[n] 的组合必须出现 0 次，等价于没有
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && (s.charAt(m) == p.charAt(n - 1) || p.charAt(n - 1) == '.');
                }else if (s.charAt(m) == p.charAt(n) || p.charAt(n) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[ls][lp];
    }

    /**
     * 声明一匹配方法 match(i, j)，代表子字符串 s 的 第 ii 至末尾字符 与 p 的 第 jj 至末尾字符 是否匹配。
     */
    int ls, lp;
    public boolean isMatch3(String s,String p){
        ls = s.length();
        lp = p.length();
        return match(s, p, 0, 0);
    }

    private boolean match(String s, String p, int i, int j) {
        if (j == lp) return i == ls;
        if (j < lp - 1 && p.charAt(j + 1) == '*'){
            if (i < ls && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')){
                return match(s, p, i + 1, j) || match(s, p, i, j + 2);
            }
            return match(s, p, i, j + 2);
        }
        if (i < ls && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))
            return match(s, p, i + 1, j + 1);
        return false;
    }

}
