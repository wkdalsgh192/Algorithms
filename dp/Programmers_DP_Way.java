package dp;

public class Programmers_DP_Way {

	private int[][] map,dp;
    private int[][] dir = {{0,1},{1,0}};
    public int solution(int m, int n, int[][] puddles) {
        // 맵 만들기
        map = new int[n+1][m+1];
        
        for (int[] puddle : puddles) map[puddle[1]][puddle[0]] = 1;
        
        dp = new int[n+1][m+1];
        pathFindHelper(1,1,n,m);
        
        return dp[1][1] % 1000000007;
    }
    private int pathFindHelper(int r, int c, int n, int m) {
        // 경계 체크
        
        if (r == n && c == m) return 1;
        if (dp[r][c] > 0) return dp[r][c] % 1000000007;
    
        int nr,nc;
        for (int i=0;i<dir.length;i++) {
            nr = r+dir[i][0];
            nc = c+dir[i][1];
            if (nr < 1 || nr >= n+1 || nc < 1 || nc >= m+1 || map[nr][nc] == 1) continue;
            dp[r][c] += pathFindHelper(nr,nc,n,m);
        }
        
        return dp[r][c] % 1000000007;
    }
    
    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            
            int[][] dp = new int[n+1][m+1];
            for (int[] puddle : puddles) {
                dp[puddle[0]][puddle[1]] = -1;
            }
            

            dp[n][m] = 1;
            int[][] dir = new int[][] {{1,0},{0,1}};
            for (int i=n;i>0;i--) {
                for (int j=m;j>0;j--) {
                    if (dp[i][j] == -1) continue;
                    int nr,nc;
                    for (int k=0;k<2;k++) {
                        nr = i+dir[k][0];
                        nc = j+dir[k][1];
                        if (nr < 1 || nr >= n+1 || nc < 1 || nc >= m+1 || dp[nr][nc] == -1) continue;
                        dp[i][j] += dp[nr][nc] % 1000000007;
                    }
                }
            }
            
            return dp[1][1]% 1000000007;
        }
    }

}
