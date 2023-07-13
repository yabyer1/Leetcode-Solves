class Solution {
    public int findPeakElement(int[] nums) {
        /*
        if(nums.length < 2 || nums[0] > nums[1]){
            return 0;
        }
        if(nums[nums.length - 2] < nums[nums.length - 1]){
            return nums.length - 1;
        }
        long prev = -1;
        long nxt = 1;
        for(int i = 1; i < nums.length - 1; i++){

            long cur = nums[i];
            /*
            if(i == 0 || i == nums.length - 1){
            if(i - 1 == -1){
                prev = Integer.MIN_VALUE;
            }
            if(i + 1 == nums.length){
                nxt = Integer.MIN_VALUE;
            }
            }
            else{
                
                prev = nums[i - 1];
                nxt = nums[i+ 1];
            
            if(cur > prev && cur > nxt){
                return i;
            }

        }

        return -1;
    }
    */
     if(nums.length < 2 || nums[0] > nums[1]){
            return 0;
        }
        if(nums[nums.length - 2] < nums[nums.length - 1]){
            return nums.length - 1;
        }
   return BinSearch(1, nums.length - 2, nums);
    }
    int BinSearch(int l, int h, int[] nums){
        while(l < h){
            int mid = (l + h) / 2;
            if(nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }
            else if(nums[mid] < nums[mid - 1]){
                    h = mid - 1;
            }
            else{
                return mid;
            }
        }
        return l;
    }
}