class Solution {
    int[][] dp;
    public boolean canCross(int[] stones) {
        dp = new int[stones.length][stones.length];
        for(int[]g : dp)
        Arrays.fill(g, -1);
        if(stones[1] != 1){
            return false;
        }
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < stones.length; i++){
            hs.add(stones[i]);
            hm.put(stones[i], i);
        }
        
       int x =  memo(1, stones, 1, hs, hm);
       if(x == 1){
           return true;
       }
       return false;
    }
    int memo(int i, int[] stones, int jump, HashSet<Integer> hs, HashMap<Integer,Integer> hm){
        if(i == stones.length - 1){
            return 1;
        }
        if(dp[i][jump] != -1){
            return dp[i][jump];
        }
        int curPos = stones[i];
       // System.out.println(curPos);
        int ch = 1000;
        for(int j = -1; j < 2; j++){
            if(jump + j == 0){
                continue;
            }
            if(hs.contains(curPos +  jump + j)){
               // System.out.println(curPos +" " + jump + " " + j);
             ch = Math.min( ch,  memo(hm.get(curPos + jump + j), stones, jump + j, hs, hm));
            }
        }
            dp[i][jump] = ch;
        return ch;

    }
}