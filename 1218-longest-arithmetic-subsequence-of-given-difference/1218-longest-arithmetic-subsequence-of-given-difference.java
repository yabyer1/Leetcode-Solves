class Solution {
    public int longestSubsequence(int[] arr, int difference) {
       HashMap<Integer, Integer> dp = new HashMap<>();
       int res = 1;
       for(int i = 0; i < arr.length; i++){
           int cur = arr[i];
           int prev = cur - difference;
           int ans = 1;
           if(dp.containsKey(prev)){
                dp.put(cur, dp.get(prev) + 1);
                ans = dp.get(cur);
           }
           else{
               dp.put(cur, 1);
           }
        res = Math.max(ans, res);
       }
       return res;
        /*
        Arrays.fill(dp, 1);
        for(int i  = 0; i < arr.length; i++){
          //  arr[i] = 1;
            for(int j = i + 1; j < 0; j++){
                if(arr[j] - arr[i] == difference){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int x : dp){
            ans = Math.max(ans, x);
        }
        return ans;
        */
        // return diffMemo(arr, dp, 0, difference, 0, Integer.MIN_VALUE);
        /*for(int j: dp){
System.out.println(j);
        }
        return 10;\*/
    }
    /*
    int memo(int[] arr, int[] dp, int i, int difference, int streak){
        if(dp[i] != 0){
            return dp[i];
        }
        int x = streak;
      
            for(int j = i + 1; j < arr.length; j++){
                
                if(arr[j] - arr[i] == difference){
                    x = Math.max(memo(arr, dp, j, difference, streak + 1), x);
                }
                else{
                    x = Math.max(x, memo(arr, dp, j, difference, 1));
                }
            }
            
     
        dp[i] = x;
        return x;
    }
    */
       int diffMemo(int[] arr, int[] dp, int i, int difference, int streak, int prev){
           if(i >= arr.length){
          return 0;
           }
        if(dp[i] != 0){
            return dp[i];
        }
           
        int x = 1;
       
            if(i == 0){
            int temp = Math.max(diffMemo(arr, dp, i + 1, difference, 0, Integer.MAX_VALUE) , diffMemo(arr, dp, i + 1, difference, 1, arr[i]) + 1);
            System.out.println(temp);
            x = Math.max(temp, x);
            }
           else{
                if(arr[i] - prev == difference){
                  x = Math.max(x, diffMemo(arr, dp, i + 1, difference, streak + 1, arr[i]) + 1);
              
                }
               else{
                int temp = Math.max(diffMemo(arr, dp, i + 1, difference, streak, prev), diffMemo(arr, dp, i + 1, difference, 1, arr[i]));
                       x = Math.max(temp, x);
               }
                System.out.println(x);
           }
         
     
        dp[i] = x;
        return x;
    }
    
}