class Solution {
    public int longestSubarray(int[] nums) {
      int ans = 0;
      int i = 0;
      while(i < nums.length && nums[i] != 0){
          ans++;
          i++;
      }
      if(ans == nums.length){
          return ans - 1;
      }
      int res = ans;
      int temp = 0;
      i++;
         // System.out.println(i + "      " + res + "      " + temp + "      " + ans);
        for(int j = i; j < nums.length; j++){
              //System.out.println(i + "      " + res + "      " + temp + "      " + ans);
                if(nums[j] == 1){
                    temp++;
                }
                if(nums[j] == 0){
                  
                    ans = Math.max(ans, res + temp);
                    res = temp;
                    temp = 0;
                }
        }
        ans = Math.max(ans, res + temp);
        return ans;
    }
}