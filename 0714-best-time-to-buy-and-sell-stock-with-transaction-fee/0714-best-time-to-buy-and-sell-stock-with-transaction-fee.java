class Solution {

    public int maxProfit(int[] prices, int fee) {
        int [][] dp = new int[prices.length][2];
       
      //Arrays.fill(dp, -1);
       return  memo(dp, prices, fee, 0, 0, 0);
        // for(int x : dp) System.out.println(x);
         //return dp[0];
    }

    int memo(int[][] dp, int[] prices, int fee, int i, int chosenStock, int StartPrice){
        if(i >= prices.length){
            return 0;
        }
        
        if(dp[i][chosenStock] != 0){
            return dp[i][chosenStock];
        }
        
        int profit = 0;
        if(chosenStock == 1){
            profit += Math.max((memo(dp, prices, fee, i + 1, 0, 0) + prices[i]), memo(dp, prices, fee, i+1, 1, StartPrice));
        }
        else{
            profit += Math.max(memo(dp, prices, fee, i + 1, 0, 0), -prices[i] - fee  + memo(dp, prices, fee, i + 1, 1, prices[i]));
        }
            dp[i][chosenStock] = profit;
            return dp[i][chosenStock];
    }
}