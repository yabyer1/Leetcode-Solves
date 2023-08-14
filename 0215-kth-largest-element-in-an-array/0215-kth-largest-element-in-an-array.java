class Solution {
    public int findKthLargest(int[] nums, int k) {
      
        PriorityQueue<Integer> p = new PriorityQueue<>( (a, b) -> (b - a));
        for(int i : nums){
            p.add(i);
        }
        for(int i = 0; i < k- 1; i++){
            p.remove();
        }
        return p.peek();
    }

}