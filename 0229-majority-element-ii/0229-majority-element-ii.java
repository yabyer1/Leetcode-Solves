class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ch = new ArrayList<>();
        Arrays.sort(nums);
        int i  = 0;
        while(i < nums.length){
            int count = 1;
            while(i < nums.length - 1 && nums[i] == nums[i + 1]){
                count++;
                i++;
            }
            if(count > nums.length / 3){
                ch.add(nums[i]);
            }
            i++;
        }
    return ch;
    }
}