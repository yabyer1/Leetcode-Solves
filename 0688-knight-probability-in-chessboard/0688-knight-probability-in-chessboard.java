class Solution {
    int[][] dir ={
        {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}
    };
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k];
        for(double[][] x : dp){
            for(double[] y : x){
                Arrays.fill(y, - 1);
            }
        }
        return memo(dp, row, column, 0, k);
    }
    double memo(double[][][] dp, int row, int column, int turn, int k){
        if(turn == k){
            return 1;
        }
        /*
        if(row < 0 || row > dp.length - 1 || column > dp[row].length - 1 || column < 0){
            return 0;
        }
        */
        if(dp[row][column][turn] != -1){
            return dp[row][column][turn];
        }
        double prob = 0;
        /*
        for(int[] dirs : dir){
            int c = column + dirs[1];
            int r = row + dirs[0];
            if(r < 0 || r > dp.length - 1 || c > dp[row].length - 1 || c < 0){
            continue;
            }
            prob++;
        }
        */
          
          double ans = 0;
             for(int[] dirs : dir){
            int c = column + dirs[1];
            int r = row + dirs[0];
            if(r < 0 || r > dp.length - 1 || c > dp[row].length - 1 || c < 0){
            continue;
            }
            ans +=  memo(dp, r, c, turn + 1, k);
            }
           dp[row][column][turn] = ans / 8;
           return dp[row][column][turn];
        }
        }
    
