class Solution {
    private double[][][] dp;
    private int[] dr = {-2,-2,-1,-1,1,1,2,2};
    private int[] dc = {-1,1,-2,2,-2,2,-1,1};
    public double knightProbability(int N, int K, int r, int c) {
        dp = new double[K][N][N];
        return probabilityHelper(N,K,r,c,0,1);
    }
    private double probabilityHelper(int N, int K, int r, int c, int cnt, double p) {
        if (cnt == K) return p;
        
        if (dp[cnt][r][c] > 0) return dp[cnt][r][c];
        
        int nr,nc;
        double sum=0;
        for (int i=0;i<8;i++) {
            nr = r + dr[i];
            nc = c + dc[i];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            
            sum += probabilityHelper(N,K,nr,nc,cnt+1,p*((double)1/8));
        }
        
        dp[cnt][r][c] = sum;
        return dp[cnt][r][c];
    }
}
