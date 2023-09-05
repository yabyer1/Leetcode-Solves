class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        Arrays.fill(dp, 2000);
        memo(days, costs, days[0], 0, dp);
        /*
        for(int l : dp){
            System.out.println(l);
        }
        */
        return dp[days[0]];
    }
    int memo(int[] days, int[] costs, int curDay, int curIn, int[] dp){
       // System.out.print(curDay + " " + days[curIn]);
        if(curIn >= days.length || curDay > days[days.length - 1]){
            
            return 0;
        }
        if(curDay > days[curIn]){
         
        return    memo(days, costs, curDay, curIn + 1, dp);
        }
        if(dp[curDay] != 2000){
               //  System.out.println(days[curDay]);
            return dp[curDay];
        }
        int MinPay = Integer.MAX_VALUE;
        if(curDay == days[curIn]){
      // System.out.println(" here");
        MinPay = Math.min(memo(days, costs, curDay + 1, curIn + 1, dp) + costs[0], memo(days, costs, curDay + 7, curIn + 1, dp) + costs[1]);
        MinPay = Math.min(MinPay, memo(days, costs, curDay + 30, curIn + 1, dp) + costs[2]);
        }
        else if(curDay < days[curIn]){
            int SkipDay = memo(days, costs, curDay + 1, curIn, dp);
             MinPay = Math.min(memo(days, costs, curDay + 1, curIn + 1, dp) + costs[0],memo(days, costs, curDay + 7, curIn + 1, dp) + costs[1]);
             MinPay = Math.min(MinPay, memo(days, costs, curDay + 30, curIn + 1, dp) + costs[2]);   
             MinPay = Math.min(MinPay, SkipDay);
          //    System.out.println(2);
        }

        dp[curDay] = MinPay;
        return dp[curDay];
    }
}