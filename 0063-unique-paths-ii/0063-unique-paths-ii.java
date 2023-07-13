class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
              if(i - 1 > -1){
                  dp[i][j] += dp[i - 1][j];
              }
               if(j - 1 > -1){
                  dp[i][j] += dp[i][j - 1];
              }

            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}