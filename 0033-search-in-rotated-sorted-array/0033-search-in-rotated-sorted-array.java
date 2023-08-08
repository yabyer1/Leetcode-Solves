class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] == target) return 0;
        if(nums[nums.length - 1] == target) return nums.length - 1;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > nums[nums.length - 1]){
                lo = mid + 1;
            }
            else if(nums[mid] < nums[nums.length - 1]){
                hi = mid;
            }
        }
       int pivot  = lo;
        lo = 0;
        hi = pivot - 1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target ){
                hi = mid - 1;
            }
            else if(nums[mid] < target){
                 lo = mid + 1;
            }
        }
        if(lo > -1 && lo < nums.length && nums[lo] == target){
            return lo;
        }
          lo = pivot + 1;
        hi = nums.length - 1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target ){
                hi = mid - 1;
            }
            else if(nums[mid] < target){
                 lo = mid + 1;
            }
        }
        if(lo >= 0 && lo < nums.length && nums[lo] == target){
            return lo;
        }
        return -1;
}
}