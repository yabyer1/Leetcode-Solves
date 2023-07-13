class Solution {
    public boolean buddyStrings(String s, String goal) {
       if(s.length() != goal.length()){
           return false;
       }

       /*
       for(int i = 0; i < goal.length(); i++){
           if(!s.contains(String.valueOf(goal.charAt(i)))){
               return false;
           }
       }
       */
       int difC = 0;
       int[] chars = new int[26];
       int[] checks = new int[26];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                difC++;
            }
            if(s.charAt(i) == goal.charAt(i)){
               chars[s.charAt(i) % 26]++;
            }
            checks[s.charAt(i) % 26]++;
            checks[goal.charAt(i) % 26]--;
        }
         for(int x : checks){
                if(x != 0){
                    return false;
                }
         }

        if(difC == 2){
            return true;
        }
        
        if(difC < 2){
          
                
            for(int i : chars){
                if(i > 1){
                  return true;
                }
            }
            
           
        }
        
       return false;
    }
}