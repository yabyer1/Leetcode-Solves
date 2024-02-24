class UF{
    int n;
    int[] parents;
    UF(int n, int nxt){
        parents = new int[n];
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
        }
        parents[nxt] = 0; // first person learns it from the 0th guy
    }
    void reSet(int n, int i){
        parents[n] = i;
    }
    int find(int n){
        if(parents[n] == n){
            return n;
        }
        return parents[n] = find(parents[n]);
    }
    void union(int x1, int y1){
        int parent1 = find(x1);
        int parent2 = find(y1);
        if(parent1 != parent2){
            parents[parent2] = parents[parent1];
        }
    }
}
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(firstPerson);
        UF set = new UF(n, firstPerson);
        boolean flag = false;
        Stack<Integer> flush = new Stack<>();
        for(int i = 0; i < meetings.length; i++){
            if(i != 0 && meetings[i][2] != meetings[i - 1][2] ){
                if(flag == true){
                while(!flush.isEmpty() ){
                    int nxt = flush.pop();
                    if(set.find(nxt) == 0){
                    
                   // set.union(0, nxt);
                   if(!ans.contains(nxt))
                    ans.add(nxt);
                    }
                    else{
                        set.reSet(nxt, nxt);
                    }
                }
                flag = false;
                }
                else{
                    while(!flush.isEmpty() ){
                    int nxt = flush.pop();
                    set.reSet(nxt, nxt);
                }
                }
               
                    flush.clear();
               
            }
            
            if(set.find(meetings[i][0]) == 0 && set.find(meetings[i][1]) == 0){
                
                continue;
            }
            if(set.find(meetings[i][0]) != 0 && set.find(meetings[i][1]) != 0){
                set.union(meetings[i][0], meetings[i][1]);
                flush.add(meetings[i][0]);
                flush.add(meetings[i][1]);
                continue;
            }
             if(set.find(meetings[i][0]) == 0 && set.find(meetings[i][1]) != 0){
                    flag = true;
               set.union(meetings[i][0], meetings[i][1]);
               ans.add(meetings[i][1]);
            }
             if(set.find(meetings[i][0]) != 0 && set.find(meetings[i][1]) == 0){
                 flag = true;
               set.union(meetings[i][1], meetings[i][0]);
               ans.add(meetings[i][0]);
            }

        }
        if(flag == true){
             while(!flush.isEmpty()){
                    int nxt = flush.pop();
                    if(set.find(nxt) == 0 && !ans.contains(nxt)){
                   // set.union(0, nxt);
                    ans.add(nxt);
                    }
                }
        }
        return ans;
    }
}