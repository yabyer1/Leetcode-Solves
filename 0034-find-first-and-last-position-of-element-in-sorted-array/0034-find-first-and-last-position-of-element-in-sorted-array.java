class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] check = new int[2];
        int lo = 0; int hi = nums.length - 1;

        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                lo = mid;
                break;
            }
            else if(nums[mid] > target){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        if(nums.length == 0 || nums[lo] != target){
            check[0] = -1;
            check[1] = -1;
            return check;
        }
        //System.out.println(nums[lo]);
        check[0] = findlo(0, lo - 1, nums, nums[lo]);
        check[1] = findhi(lo + 1, nums.length -1, nums, nums[lo]);
        if(check[0] == -1){
                check[0] = lo;
    }
        if(check[1] == -1){
            check[1] = lo;
        }
        return check;
    }
    int findlo(int l, int h, int[] nums, int target){
       
        while(l < h){
            int mid = (l + h) / 2; //rodnd down to check bottom
            if(nums[mid] == target){
                h = mid;
            }
            
            else if(nums[mid] < target){
                l = mid + 1;
            }
            
            else{
                h = mid - 1;
            }
        }
        if(l < 0 || nums[l] != target)
        return -1;
        return l;
    }
       int findhi(int l, int h, int[] nums, int target){
        
        while(l < h){
           
            int mid = h - (h - l) / 2; //round up to check top
          
            if(nums[mid] == target){
                l = mid;
            }
            
            else if(nums[mid] > target){
                h = mid - 1;
            }
            
            else{
                l = mid + 1;
            }

        }
        if( l >= nums.length || nums[l] != target)
        return - 1;
        return l;
    }
}