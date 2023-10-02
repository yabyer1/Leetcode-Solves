class Solution {
    public boolean winnerOfGame(String colors) {
        int A = 0;
        int b = 0;
        for(int i = 1; i < colors.length() - 1; i++){
                if(colors.charAt(i) ==  colors.charAt(i - 1) && colors.charAt(i + 1) == colors.charAt(i)){
                     if   (colors.charAt(i) == 'A'){
                            A += 1;
                        }
                        else{
                            b +=1;
                        }
                }
        }
        if(A <= b){
            return false;
        }
        return true;
    }
}