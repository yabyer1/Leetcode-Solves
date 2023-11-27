class Solution {
       int mod = 1000000007;
    public int knightDialer(int n) {
        if(n ==1){
            return 10;
        }
     
        HashMap<Integer,ArrayList<Integer>> ar = new HashMap<>();
        for(int i = 0; i < 10; i++){
            ar.put(i, new ArrayList<>());
        }
        ar.get(0).add(4); ar.get(0).add(6);
        ar.get(1).add(8); ar.get(1).add(6);
        ar.get(2).add(7); ar.get(2).add(9);
        ar.get(3).add(4); ar.get(3).add(8);
         ar.get(4).add(3); ar.get(4).add(0); ar.get(4).add(9);
         ar.get(6).add(1); ar.get(6).add(7);ar.get(6).add(0);
         ar.get(7).add(6);ar.get(7).add(2);
        ar.get(8).add(1);ar.get(8).add(3);
        ar.get(9).add(2);ar.get(9).add(4);

        int[][] o = new int[10][n + 1];
        int z = 0;
        for(int i = 0; i < 10; i++){
            if(i == 5){
                continue;
            }
              int temp = find(i, n, ar, o) % mod;
    z = (int) ((z + temp) % mod);
            //z = (int)(z + ( (long)find(i, n - 1, ar, o) % mod)) %mod;
              //   System.out.println(z);
            //  System.out.println();
        }
        return z;

    }
    int find(int index, int turn, HashMap<Integer,ArrayList<Integer>> x, int[][] n){
           // System.out.println(index + " " + turn);
        if(turn == 1){
            return 1;
        }
        if(n[index][turn] != 0){
            return n[index][turn];
        }
        int ans = 0;
        for(int i = 0; i < x.get(index).size(); i++){
              //  ans =(int) (ans + (( (long) find(x.get(index).get(i), turn - 1, x, n) + 1) % mod)) % mod  ;
                 int temp = find(x.get(index).get(i), turn - 1, x, n) % mod;
              ans = (int) ((ans + temp) % mod);
        }
        n[index][turn] = ans;
        return n[index][turn];
    }

}