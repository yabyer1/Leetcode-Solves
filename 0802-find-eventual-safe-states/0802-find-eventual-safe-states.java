class Solution {
     List<Integer> ans = new ArrayList<>();
     int[] good;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        good = new int[graph.length];
    int[] bad = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            HashSet<Integer> check = new HashSet<Integer>();
            
           if( isSafe(graph, i, check, bad)){
               ans.add(i);
           }
        }

        return ans;
    }
    boolean isSafe(int[][] graph, int i, HashSet<Integer> check, int[] bad){
        if(good[i] == 1){
            return true;
        }
        if(graph[i].length == 0){
         good[i] = 1;
            return true;
        }
          if(check.contains(i)){
            return false;
        }
        check.add(i);
        for(int j = 0; j < graph[i].length; j++){
            if(ans.contains(graph[i][j]) || good[graph[i][j]] == 1){
                continue;
            }
            if(bad[graph[i][j]] == 1) {
                bad[i] = 1;
                return false;
            }
            HashSet<Integer> temp = new HashSet<>(check);
          if(! (isSafe(graph, graph[i][j], temp, bad))){
                bad[i] = 1;
              return false;
          }
            
        }
        good[i] = 1;
        return true;
    }
}