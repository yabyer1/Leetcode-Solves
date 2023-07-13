class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
/*        for(int i = 0; i < nums.length; i++){
            if(i - k < 0 || i + k >= nums.length){
                ans[i] = -1;
                continue;
            }
            */
            int i = 0;
            while(i - k < 0 && i < nums.length){
                ans[i] = -1;
                i++;
            }
            if(i -k > -1 && i + k < nums.length){
                long tempSum = 0;
                for(int j = i -k; j <= i+ k; j++){
                    tempSum += nums[j];
                }
                ans[i] = (int) (tempSum / (2 * k + 1));
                i++;
                while(i -k > -1 && i + k < nums.length){
                    tempSum -= (nums[i - k - 1]);
                    tempSum += (nums[i + k]);
                    ans[i] =  (int) (tempSum / (2 * k + 1));
                    i++;
                }
            }
             while(i + k >= nums.length && i < nums.length ){
                ans[i] = -1;
                i++;
            }
            return ans;
        }
}