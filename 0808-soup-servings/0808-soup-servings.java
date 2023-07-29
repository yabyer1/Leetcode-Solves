
class Solution {
    Map<Pair<Integer, Integer>, Double> j = new HashMap<>();
    public double soupServings(int n) {
        double newLim = Math.ceil((double)n / 25);
     //   System.out.print(newLim);
         for (int k = 1; k <= newLim; k++) {
            if (memo(k, k) > 1 - 1e-5) {
                return 1.0;
            }
        }
        return memo((int)newLim, (int)newLim);
    }
    double memo( int soupA, int soupB){
        if(soupA <= 0 && soupB <= 0){
            return .5;
        }
        if(soupA <= 0){
            return 1;
        }
        if(soupB <= 0){
            return 0;
        }
        if(j.containsKey(new Pair<>(soupA, soupB))){
            return j.get(new Pair<>(soupA, soupB));
        }
        double count = 0;
        count += memo(soupA - 4, soupB);
        count += memo(soupA - 3, soupB - 1);
        count += memo(soupA - 2, soupB - 2);
        count += memo(soupA - 1, soupB - 3);

        j.put(new Pair<>(soupA, soupB), count/ 4);
        
        return count/4;
    }
}