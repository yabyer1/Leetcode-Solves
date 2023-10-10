class Solution {
    public int minOperations(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        ArrayList<Integer> x = new ArrayList<>();
        x.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
                if(nums[i] != nums[i - 1]){
                    x.add(nums[i]);
                }
        }
        int str = 0;
        for(int i = 0; i < x.size() - 1; i++){
           // System.out.println(i);
            str=Math.max(str, BinSearch(nums,i, x) + 1 );
        }
        return nums.length -  str;
        /*
        int i = 1;
        int str = 0;
        while(i < nums.length){
           
           int ns = 0;
            while( i < nums.length &&  (nums[i] - nums[i - 1] > 0) &&  (nums[i] - nums[i - 1] < nums.length)){
                    ns++;
                    i++;
               
                str = Math.max(ns, str);
            }
          i++;
        }
        return nums.length - 1 - str;
        */
    }
    int BinSearch(int[] nums, int i, ArrayList<Integer> x){
        int l = i + 1;
        int h = x.size() - 1;
        while(l < h){
            int m = h -    (h - l) / 2;
            if(x.get(m) - x.get(i) < nums.length){
                l = m;
            }
            else{
                h = m - 1;
            }
        }
        if(l >= i + 1 && x.get(l) - x.get(i) < nums.length){
           // System.out.println(i + " " + l);
            return l - i;
        }
        return 0;
    }
}