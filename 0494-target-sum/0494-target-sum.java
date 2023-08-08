class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        
        for (int num : nums) {
            sum += num;
        }
        
        int finalTarget = (sum - target) / 2;
        
        if (finalTarget < 0 || (sum - target) % 2 != 0) {
            return 0;
        }
        
        int[][] dp = new int[n][finalTarget + 1];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return helper(nums, dp, n - 1, finalTarget) % ((int) 1e9 + 7);
    }
    
    public int helper(int[] nums, int[][] dp, int idx, int target) {
        if (idx == 0) {
            if (target == 0 && nums[0] == 0) {
                return 2;
            }
            if (target == 0 || nums[idx] == target) {
                return 1;
            }
            return 0;
        }
        
        if (dp[idx][target] != -1) {
            return dp[idx][target] % ((int) 1e9 + 7);
        }
        
        int notTake = helper(nums, dp, idx - 1, target);
        int take = 0;
        if (nums[idx] <= target) {
            take = helper(nums, dp, idx - 1, target - nums[idx]);
        }
        
        return dp[idx][target] = (notTake + take) % ((int) 1e9 + 7);
    }
}
