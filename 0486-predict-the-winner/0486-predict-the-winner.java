class Solution {
   
    public boolean PredictTheWinner(int[] nums) {
       int[][] memo = new int[nums.length][nums.length];
       //f(i, j) = Max(nums[i] - f(i + 1, j), nums[j] - f(i, j - 1))
       return DP(memo, nums, 0, nums.length - 1) > -1 ? true : false;
    }
    int DP(int[][] memo, int[] nums, int lo, int hi){
        if(lo == hi){
            return nums[hi];
        }
        if(memo[lo][hi] != 0){
            return memo[lo][hi];
        }
        int ls = nums[lo] -DP(memo, nums, lo + 1, hi);
        int rs = nums[hi] - DP(memo, nums, lo, hi - 1);
        memo[lo][hi] = Math.max(ls, rs);
        return memo[lo][hi];
    }
   
}