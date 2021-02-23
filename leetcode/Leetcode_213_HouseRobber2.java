class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        return Math.max(robHelper(0,nums.length-2,nums),robHelper(1,nums.length-1,nums));
    }
    public int robHelper(int s, int e, int[] nums) {
        int[] dp = new int[nums.length];
        dp[s] = nums[s];
        dp[s+1] = Math.max(dp[s], nums[s+1]);
        for(int i=s+2;i<=e;i++) dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        
        return dp[e];
    }
}
