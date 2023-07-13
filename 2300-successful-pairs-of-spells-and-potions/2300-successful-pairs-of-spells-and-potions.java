class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] keys = new int[spells.length];
        for(int i = 0; i < spells.length; i++){
            keys[i] = potions.length - BinSearch(0, potions.length - 1, (long) spells[i], success, potions);
        }
        return keys;
    }
    int BinSearch(int l, int h, long spell, long success, int[] potions){
        while(l < h){
            int mid = (h + l) / 2;
            long check = potions[mid];
            if( spell * check == success){

                h = mid;
                /*
                while(mid > 1 && potions[mid] == potions[mid - 1]){
                    mid--;
                }
                 return mid;
               */
            }
            else if(( spell * check < success)){
                l = mid + 1;
            }
            else{
                h = mid;
            }
        }
        if(potions[l] * spell < success) return potions.length;
        return l;
    }
}