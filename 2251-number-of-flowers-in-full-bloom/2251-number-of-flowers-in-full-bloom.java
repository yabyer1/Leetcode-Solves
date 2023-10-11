class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] riz = new int[people.length];
        Arrays.sort(flowers, (a, b) -> (a[0] - b[0]));
        for(int i = 0; i < riz.length; i++){
            if(people[i] > flowers[flowers.length -1][0]){
                riz[i] = flowers.length;
            }
            else{
            riz[i] = BinSearch(people[i], flowers);
            }
        }
         Arrays.sort(flowers, (a, b) -> (a[1] - b[1]));
        for(int i = 0; i < riz.length; i++){
            riz[i] = Math.max(riz[i] - binSearch(people[i], flowers), 0);
        }
        return riz;
    }
    int BinSearch(int target, int[][] flowers){
        int l = 0;
        int h = flowers.length - 1;
        while(l < h){
           // int m = (l + h) / 2;
           int m = h- (h - l) / 2;
            //System.out.println(m);
          //  System.out.println(flowers[m][0] + " " + target);
            if(flowers[m][0] < target){
                l = m + 1;
            }
            else if(flowers[m][0] > target){
                h = m - 1;
            }
            else{
              l = m;
            }
        }
        //System.out.println(l + " " + " " + target);
        if(l == 0 && flowers[l][0] > target){
            return 0;
        }
        if(flowers[l][0] > target){
            return l;
        }
        return l + 1;
    }
       int binSearch(int target, int[][] flowers){
        int l = 0;
        int h = flowers.length - 1;
        while(l < h){
            int m = h - (h - l) / 2;
         // int m = (l + h) / 2;
            if(flowers[m][1] < target){
                l = m + 1;
            }
            else if(flowers[m][1] >= target){
                h = m - 1;
            }
            
        }
       //  System.out.println(l + " " + " " + target);
        if(l == 0 && flowers[l][1] >= target){
            return 0;
        }
       if(l < flowers.length && flowers[l][1] >= target){
           return l;
       }
        return l + 1;
    }
}