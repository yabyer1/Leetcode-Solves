class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n==1) return 0;
        int finalmask = (1<<n) - 1;
        boolean [][] vis = new boolean[n][finalmask];
        Queue<Pair<Integer, Integer>> x = new LinkedList<>();
        for(int i = 0; i < graph.length; i++){
            int startBit = (1 << i);
            vis[i][startBit] = true;
            Pair <Integer, Integer> e = new Pair<>(i, startBit);
            x.add(e);
        }
        int turns = 0;
        while(!x.isEmpty()){
            int j = x.size();
          
            while(j-- > 0){
                Pair<Integer, Integer> popPair = x.remove();
                int node = popPair.getKey();
                int mask = popPair.getValue();
                if(mask == finalmask){
                    return turns;
                }
                for(int z : graph[node]){
                  int NewMask =  (mask | (1 << z));
                  if(NewMask == finalmask){
                      return turns + 1;
                  }
                  if(  vis[z][NewMask] == true){
                      continue;
                  }
                  vis[z][NewMask] = true;
                  x.add(new Pair<>(z, NewMask));
                }
            }
              turns++;
        }
return -1 ;
    }
}