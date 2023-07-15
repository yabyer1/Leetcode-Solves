class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Arrays::compare);
        int[][] dp = new int[k][events.length];
       return memo(dp, events, k - 1, 0);
    }  
    int memo(int[][] dp, int[][] events, int n, int i){
        if(n < 0 ||  i >= dp[n].length || i < 0){
            return 0;
        }
        if(dp[n][i] != 0){
            return dp[n][i];
        }
        int x = BinSearch(events, events[i][1]);
        dp[n][i] = Math.max(memo(dp,events, n, i + 1), memo(dp,events, n - 1, x) + events[i][2]);
        return dp[n][i];
    }
    int BinSearch(int[][] events, int target){
        int h = events.length;
        int l = 0;
        while(l < h){
          int m = (l + h) / 2;
          if(events[m][0] > target){
              h = m;
          } 
          else{
              l = m + 1;
          }
    
        }
        return l;
    }
}