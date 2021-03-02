class Solution {
    private int R,C;
    private int[][][] dp;
    public int cherryPickup(int[][] grid) {
        R = grid.length;
        C = grid[grid.length-1].length;
        dp = new int[R][C][C];
        return cherryHelper(0,0,C-1,grid);
    }
    private int cherryHelper(int r, int c1, int c2, int[][] grid) { // 주어진 좌표에서 얻을 수 있는 최대 체리값 + (r+1) +(r+2)+....
        if (r < 0 || r >= R || c1 < 0 || c1 >= C || c2 < 0 || c2 >= C || c1 > c2) return 0;
        
        if (dp[r][c1][c2] > 0) return dp[r][c1][c2];
        
        // 두 로봇이 갈 수 있는 모든 위치를 찾아서, 거기서 얻을 수 있는 체리의 최대값을 찾는 과정
        int max=0;
        for (int i=-1;i<=1;i++) {
            for (int j=-1;j<=1;j++) {
                max = Math.max(max, cherryHelper(r+1,c1+i,c2+j,grid));
            }
        }
        
        return dp[r][c1][c2]= max + grid[r][c1]+ (c1 == c2 ? 0 : grid[r][c2]);
    }
    
    public int cherryPickup(int[][] grid) {
        int C = grid[0].length;
        int[][] dp = new int[C][C], old = new int[C][C];
        for(int r = grid.length - 1; r >= 0; r--) {
            for(int c1 = Math.min(r, C - 1); c1 >= 0; c1--) {
                for(int c2 = Math.max(c1, C - 1 - r); c2 < C; c2++) {
                    int max = 0;
                    for(int i = c1 - 1; i <= c1 + 1; i++) {
                        for(int j = c2 - 1; j <= c2 + 1; j++) {
                            if(i >= 0 && i < C && j >= 0 && j < C && i <= j) max = Math.max(max, old[i][j]);
                        }
                    }
                    dp[c1][c2] = max + grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
                }
            }
            int[][] temp = dp; dp = old; old = temp;
        }
        return old[0][C - 1];
    }
}
