class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int mc = 0;
        List<Boolean> and = new ArrayList<>();
        for(int g : candies){
        mc = Math.max(g, mc);
        }
       for(int i = 0; i < candies.length; i++){
           if(candies[i] + extraCandies >= mc){
               and.add(true);
           }
           else{
               and.add(false);
           }
       }
       return and;
    }
}