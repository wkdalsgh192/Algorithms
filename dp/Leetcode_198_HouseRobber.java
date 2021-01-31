package dp;

public class Leetcode_198_HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        if (nums.length == 3)
            return Math.max(nums[0] + nums[2], nums[1]);

        nums[2] = Math.max(nums[0] + nums[2], nums[1]);
        for (int i = 3; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 2], nums[i - 3]) + nums[i];
        }

        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }

    // Sample Solution
    // public int rob(int[] nums) {
    // int prevNo = 0;
    // int prevYes = 0;
    // for (int n : nums) {
    // int temp = prevNo;
    // prevNo = Math.max(prevNo, prevYes);
    // prevYes = n + temp;
    // }

    // return Math.max(prevNo, prevYes);
    // }
}
