
class Solution {
    class UF{
        int[] parent;
        
        public UF(int n){
         parent = new int[n];
         for(int i = 0; i < parent.length; i++){
             parent[i] = i;
         }
        }
         int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
         }
         void union(int x1, int y1){
             int parent_x = find(x1);
             int parent_y = find(y1);
             if(parent_x != parent_y){
                 parent[parent_y] = parent_x;
                
             }
         }
        
    }
    int CalcDistance(int x1, int x2, int y1, int y2){

        return Math.abs(x1 - y1) + Math.abs(x2 - y2);
    }
    public int minCostConnectPoints(int[][] points) {
        int[][] distancesFound = new int[points.length * (points.length -1 ) / 2][3];
       // HashSet<int[]> hs = new HashSet<>();
        int k = 0;
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
              distancesFound[k][0] = i;
              distancesFound[k][1] = j;
              distancesFound[k][2] = CalcDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
              k++;
            }
           
        }

        Arrays.sort(distancesFound, Comparator.comparingInt(a -> a[2]));
        /*
        for(int i = 0; i < distancesFound.length;i++){
            System.out.println(distancesFound[i][0] + " " + distancesFound[i][1] + " " + distancesFound[i][2]);
        }
        */
        UF DSU = new UF(points.length);
        int Edges = 0;
        int MinWeight = 0;
        for(int i = 0; i < distancesFound.length; i++){
            if(DSU.find(distancesFound[i][0]) != DSU.find(distancesFound[i][1])){
                DSU.union(distancesFound[i][0], distancesFound[i][1]);
                Edges++;
                MinWeight += distancesFound[i][2];
            }
            if(Edges == points.length - 1){
                break;
            }
        }
        return MinWeight;
    }
}