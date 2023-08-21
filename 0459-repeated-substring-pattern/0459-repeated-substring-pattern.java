class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i  = 0; i < s.length() / 2; i++){
            if(CanMake(i, s)){
                return true;
            }
        }
        return false;
    }
    boolean CanMake(int i, String s){
        String sub = s.substring(0, i + 1);
        while(sub.length() < s.length()){
            sub += s.substring(0, i + 1);
            if(sub.equals(s)){
                return true;
            }
        }
        return false;
    }
}