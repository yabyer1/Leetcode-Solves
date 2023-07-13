class Solution {
    public String predictPartyVictory(String senate) {
        int RCount = 0;
        int DCount = 0;
        char[] SenateDota= senate.toCharArray();
        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                RCount++;
            }
            else{
                DCount++;
            }
        }
        int SL = SenateDota.length;
        int i = 0;
        int j = 0;
        while(RCount > 0 && DCount > 0){
            while(SenateDota[j % SL] == 'X'){
                j++;
            }
            char temp = SenateDota[j % SL];
            while( temp == SenateDota[i % SL] || SenateDota[i % SL] == 'X'){
                i++;
            }
            if(temp == 'R'){
                SenateDota[i % SL] = 'X';
                DCount--;
            }
            else{
                SenateDota[i % SL] = 'X';
                RCount--;
            }
            i++;
            j++;
            }
            if(DCount <= 0){
                return "Radiant";
            }
            else{
                return "Dire";
            }
        }
    }
