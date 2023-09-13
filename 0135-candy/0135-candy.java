class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 1){
            return 1;
        }
        int[] cand = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++){
            if(i == 0){
                if(ratings[i] > ratings[i + 1]){
                    cand[i] = 2;
                    cand[i + 1] = 1;
                }
                else if(ratings[i] == ratings[i + 1]){
                    cand[i] = 1; 
                    cand[i + 1] = 1;
                }
                else{
                    cand[i + 1] = 2;
                    cand[i] = 1;
                }
            }
            else if(i == ratings.length - 1){
               if(ratings[i] > ratings[ i - 1]){
                   cand[i] = cand[i - 1] + 1;
               }
               else if(ratings[i] <= ratings[i - 1]){
                   cand[i] = 1;
               }
            }
        
        else{
            if(ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]){
                cand[i] = 1;
            }
          else  if(ratings[i] > ratings[i - 1] && ratings[i] > ratings[i + 1]){
                cand[i] = cand[i - 1] + 1;
            }
           else  if(ratings[i] <= ratings[i - 1] && ratings[i] > ratings[i + 1]){
                  cand[i] = 2;
                  cand[i + 1] = 1;
           }
           else if(ratings[i] > ratings[i - 1] && ratings[i] <= ratings[i + 1]){
               cand[i] = cand[i - 1] + 1;
               cand[i + 1] = cand[i] + 1;
           }
        }
    }
    for(int i  = ratings.length -1; i > 0; i--){
        if(ratings[i] < ratings[i - 1] && cand[i- 1] <= cand[i]){
            cand[i-1] = cand[i] + 1;
        }
    }
    int rizz = 0;
    for(int j : cand){
      //  System.out.println(j);
            rizz += j;
    }
    return rizz;
    }
}