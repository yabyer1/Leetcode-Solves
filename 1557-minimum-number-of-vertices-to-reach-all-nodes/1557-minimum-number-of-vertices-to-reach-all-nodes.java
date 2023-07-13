class UF{
  public  int[] parent;
 public UF(int n){

 parent = new int[n];
 for(int i = 0; i < n; i++){
     parent[i] = i;
 }
 }
 int find(int n){
   if(parent[n] == n){
       return n;
   }
   else{
      return find(parent[n]);
   }
 }
 void Union(int x1, int x2){
     int parent1 = find(x1);
     int parent2 = find(x2);
    if(parent1 == parent2){
        return;
    }
    else{
        parent[x2] = parent1;

    }

 }
}
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<Integer>();
        Map<Integer, ArrayList<Integer>> FreqMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            FreqMap.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.size(); i++){
            FreqMap.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        UF find = new UF(n);
        for(int i  = 0; i < n; i++){
        
                for(int j = 0; j < FreqMap.get(i).size(); j++){
                    find.Union(i,FreqMap.get(i).get(j));
                }
            
        }
        for(int i = 0; i < n; i++){
            System.out.println(find.parent[i]);
            if(find.parent[i] == i){
                ans.add(i);
            }
        }

        return ans;
    }
}