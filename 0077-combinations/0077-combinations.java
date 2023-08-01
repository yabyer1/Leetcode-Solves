class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp  = new ArrayList<>();
        find(temp, 1, n, k);
        return res;
    }
    void find(List<Integer> combs, int cur, int lim, int size){
        if(combs.size() == size){
            if(!res.contains(combs)){
            res.add(new ArrayList<Integer>(combs));
            }
            return;
        }
        else if(cur > lim){
                return;
        }
      //  for(int i = cur + 1; i <= lim + 1; i++){
                List<Integer> temp = new ArrayList<>(combs);
                find(temp, cur + 1, lim, size);
                 combs.add(cur);
                 temp = new ArrayList<>(combs);
                 find(temp, cur + 1, lim, size);
       // }
    }
}