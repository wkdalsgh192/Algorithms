class Solution {
    private int R,C;
    private int[][][] dp;
    public int cherryPickup(int[][] grid) {
        R = grid.length;
        C = grid[grid.length-1].length;
        dp = new int[R][C][C];
        return cherryHelper(0,0,C-1,grid);
    }
    private int cherryHelper(int r, int c1, int c2, int[][] grid) {
        if (r < 0 || r >= R || c1 < 0 || c1 >= C || c2 < 0 || c2 >= C || c1 > c2) return 0;
        
        if (dp[r][c1][c2] > 0) return dp[r][c1][c2];
        
        int max=0;
        for (int i=-1;i<=1;i++) {
            for (int j=-1;j<=1;j++) {
                max = Math.max(max, cherryHelper(r+1,c1+i,c2+j,grid));
            }
        }
        
        return dp[r][c1][c2]= max + grid[r][c1]+ (c1 == c2 ? 0 : grid[r][c2]);
    }
}
