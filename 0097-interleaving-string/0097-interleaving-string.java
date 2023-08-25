class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.equals("") && s2.equals("") && s3.equals("")){
            return true;
        }
        if(s1.equals("") && s2.equals("") && !s3.equals("")){
            return false;
        }
        if(s1.equals("")){
            if(s2.equals(s3)){
                return true;
            }
            return false;
        }
         if(s2.equals("")){
            if(s1.equals(s3)){
                return true;
            }
            return false;
        }
        int[][][] dp = new int[s1.length()][s2.length()][s3.length()];
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                for(int k = 0; k < s3.length(); k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
         FindIf(s1, s2, s3, 0, 0, 0, dp);
         if(dp[0][0][0] == 1){
             return true;
         }
         return false;
    }
    int FindIf(String s1, String s2, String s3, int i, int j, int k, int[][][] dp){
       
        if(i == s1.length() && j == s2.length() && k == s3.length()){
            return 1;
        }
         if(k == s3.length() ){
            return 1000;
        }
          if(i == s1.length() && j == s2.length() && k < s3.length()){
            return 1000;
        }
        if(i == s1.length()){
            if(s3.substring(k).equals(s2.substring(j))){
                return 1;
            }
            return 1000;
        }
         if(j == s2.length()){
            if(s3.substring(k).equals(s1.substring(i))){
                return 1;
            }
            return 1000;
        }
        if(s3.charAt(k) != s1.charAt(i) && s2.charAt(j) != s3.charAt(k)){
            return 1000;
        }
          if(dp[i][j][k] != Integer.MAX_VALUE){
            return dp[i][j][k];
        }
        int ans =  Integer.MAX_VALUE;
        if(s1.charAt(i) == s3.charAt(k)){
            ans = Math.min(ans, FindIf(s1, s2, s3, i + 1, j, k + 1, dp));
        }
           if(s2.charAt(j) == s3.charAt(k)){
            ans = Math.min(ans, FindIf(s1, s2, s3, i, j + 1, k + 1, dp));
        }
       dp[i][j][k] = ans;
       return dp[i][j][k];
    }
}