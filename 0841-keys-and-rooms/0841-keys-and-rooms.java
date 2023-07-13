class UF{
  int[] parent;
  int nums;
  public UF(int n){
      parent = new int[n];
      nums = n;
      for(int i = 0; i < n; i++){
          parent[i] = i;
      }
  }
  public int find(int x){
      if(parent[x] == x){
          return x;
      }
      else{
          parent[x] = find(parent[x]);
      }
      return parent[x];
  }

public void union(int x, int y){
    int x1 = find(x);
    int y1 = find(y);
    if(x1 == y1){
        return;
    }
    else{
       
        parent[y1] = x1;
        nums--;
    }
}

}
class Solution {
    boolean flag = false;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      
        UF ans = new UF(rooms.size());
        /*
        for(int i = 0; i < rooms.size(); i++){
            for(int j = 0; j < rooms.get(i).size(); j++){
                    if(i != rooms.get(i).get(j)){
                       
                        ans.union(i, rooms.get(i).get(j));
                        System.out.println(ans.nums);
                        if(ans.nums == 1){
                            return true;
                        }
                    }
            }
        }
        */
        int[] visited = new int[rooms.size()];
        DFS(ans, rooms, 0, visited);
        return flag;
    }
    public void DFS(UF ans, List<List<Integer>> rooms, int i, int[] visited){
        if(visited[i] == 1){
            return;
        }
        if(rooms.get(i).size() < 1){
            return;
        }
        visited[i] = 1;
        for(int j = 0; j < rooms.get(i).size(); j++){
                ans.union(i, rooms.get(i).get(j));
                   if(ans.nums == 1){
                            flag = true;;
                        }
         DFS(ans, rooms, rooms.get(i).get(j), visited);
        }
    }

}