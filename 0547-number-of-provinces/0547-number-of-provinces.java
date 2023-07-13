class UF{
   public int[] parents;
   public int x;
    public UF(int c){
        x = c;
        parents = new int[x + 1]; //must account for starting at 1 instead of 0
        for(int i = 1; i < parents.length; i++){
            parents[i] = i;
        }
    }
    int find( int j){
        if(parents[j] == j){
            return parents[j];
        }
        parents[j] = find(parents[j]);
        return parents[j];
    }
    void union(int g1, int i1){
        int par_1 = find(g1);
        int par_2 = find(i1);
        if(par_1 == par_2){
            return;
        }
        parents[par_1] = par_2;

        x--;
       
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        UF g = new UF(isConnected.length);
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected.length; j++){
                if(i == j) continue;
                if(isConnected[i][j] == 1){
                     g.union(i + 1, j + 1);
                    
                }
                if(g.x == 0) return g.x;
            }
        }
        return  g.x;
    }
}