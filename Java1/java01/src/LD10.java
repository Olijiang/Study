
public class LD10{
    // leetcode 10 

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    // 遇到*号时，当f[i][j]与f[i][j-1]不匹配时，f[i][j] 必然等于 f[i][j - 2]
                    // 当f[i][j]与f[i][j-1]匹配时，f[i][j]是否匹配还取决于f[i-1][j]是否匹配。
                    // 当p[j]=='*'时,若s[i]==p[j-1];那么s[i]属于通配符的范围,可有可无的一个字符,f[i-1][j]匹配f[i][j]就可以匹配;
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j-2] || f[i-1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) return false;
        if (p.charAt(j - 1) == '.') return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        LD10 solution = new LD10();
        String s = "a";
        String p = "a*a";
        System.out.println((solution.isMatch(s, p))?"yes":"no");
    }
}