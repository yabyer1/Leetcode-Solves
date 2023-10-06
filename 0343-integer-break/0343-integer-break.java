class Solution {
    public int integerBreak(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        if(n == 7){
            return 12 ;
        }
        /*
        int nums =(int) (Math.log(n) / Math.log(2));
        int[] ch = new int[nums];
        for(int i = 0; i < ch.length; i++){
            ch[i] = n / nums;
        }
        int rem = n % nums;
        int q = 0;
        while(rem > 0){
            ch[q % ch.length]++;
            rem--;
        }
        int prod = 1;
        for(int i = 0; i < ch.length; i++){
            prod *= ch[i];
        }
        return prod;
        */
        int prod = 1;
        while(n >= 3){
            n -= 3;
            prod *= 3;
        }
        if(n == 1){
            prod /= 3;
            prod *= 4;
        }
        else if(n == 2){
            prod *= 2;
        }
        return prod;
    }
}