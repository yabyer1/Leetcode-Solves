class Solution {
    int[][] tz;
    Map<Character,Integer> g = new HashMap<>();

    public int countVowelPermutation(int n) {
            g.put('a', 0); g.put('e', 1); g.put('i', 2); g.put('o', 3); g.put('u', 4);
            tz = new int[5][n + 1];
        char[] x = new char[5];
        x[0] = 'a';  x[1] = 'e'; x[2] = 'i';  x[3] = 'o'; x[4] = 'u'; 
        int count = 0;
        for(char c : x){
           count = (count + Find(c, n - 1)) % 1000000007;
        }
        return count;
    }
    int Find(char cur, int n){
        if (n == 0){
            return 1;
        }
        int ck = g.get(cur);
        if(tz[ck][n] != 0){
            return tz[ck][n];
        }
        int zz = 0;
        if(cur == 'a'){
            zz =(zz + Find('e', n - 1)) % 1000000007;
        }
        else if(cur == 'e'){
               zz =(zz + Find('a', n - 1)) % 1000000007;
             zz =(zz + Find('i', n - 1)) % 1000000007;
        }
        else if(cur == 'i'){
             zz =(zz + Find('a', n - 1)) % 1000000007;
             zz =(zz + Find('u', n - 1)) % 1000000007;
             zz =(zz + Find('o', n - 1)) % 1000000007;
             zz =(zz + Find('e', n - 1)) % 1000000007;
         
        }
        else if(cur =='o'){
               zz =(zz + Find('i', n - 1)) % 1000000007;
                  zz =(zz + Find('u', n - 1)) % 1000000007;
        }
        else if(cur == 'u'){
            zz =(zz + Find('a', n - 1)) % 1000000007;
        }
        tz[ck][n] = zz;
        return zz;
    }
}