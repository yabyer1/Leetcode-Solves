class Solution {
    int ans = 0;
    public int minReorder(int n, int[][] connections) {
        int[] visited = new int[n];
        Map<Integer, ArrayList<Integer>> CorrOrder = new HashMap<>();
        Map<Integer, ArrayList<Integer>> RevOrder = new HashMap<>();
        for(int i = 0; i < connections.length; i++){
            if(RevOrder.get(connections[i][0]) == null){
                RevOrder.put(connections[i][0], new ArrayList<>());
            }
              if(CorrOrder.get(connections[i][1]) == null){
                CorrOrder.put(connections[i][1], new ArrayList<>());
            }
            /*
           RevOrder.put(connections[i][0], connections[i][1]);
           CorrOrder.put(connections[i][1], connections[i][0]);
           */
           RevOrder.get(connections[i][0]).add(connections[i][1]);
          CorrOrder.get(connections[i][1]).add(connections[i][0]);
        }
           DFS(0, connections, visited, RevOrder, CorrOrder);
        return ans;
    }
    void DFS(int i, int [][]connections, int[] visited, Map<Integer, ArrayList<Integer>> RevOrder, Map<Integer, ArrayList<Integer>> CorrOrder){
            
            if(visited[i] == 1){
                return;
            }
            visited[i] = 1;
           if(RevOrder.get(i) != null){
               for(int j = 0; j < RevOrder.get(i).size(); j++ ){
                   if(visited[RevOrder.get(i).get(j)] != 1){
               ans++;
               DFS(RevOrder.get(i).get(j), connections, visited, RevOrder, CorrOrder);
                   }
               }
           }
           if(CorrOrder.get(i) != null){
               for(int j = 0; j < CorrOrder.get(i).size(); j++){
                   if(visited[CorrOrder.get(i).get(j)] != 1){
           DFS(CorrOrder.get(i).get(j), connections, visited, RevOrder, CorrOrder);
                   }
               }
           }
    }
}