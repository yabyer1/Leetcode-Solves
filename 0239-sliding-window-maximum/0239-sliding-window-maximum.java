class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> q = new LinkedList<>();
       PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> b[1] - a[1]);
        List<Integer> ch = new ArrayList<>();
         for(int i  = 0; i < k; i++){
                q.add(new int[] {i, nums[i]});
               pq.add(new int []{  i , nums[i] });
        }
        int[] ans = pq.peek();
        ch.add(ans[1]);
        for(int i = k ; i < nums.length; i++){
               int[] check =  q.remove();
              q.add( new int []{ i, nums[i]});
               pq.add(new int []{  i , nums[i] });
             
              int[] top = pq.peek();
              if(top[0] <= check[0]){
                  top = pq.peek();
                  while(!pq.isEmpty() && top[0] < i - k + 1){
                       pq.remove();
                     // System.out.println(top[0]);
                      top = pq.peek();
                  }
              }
              ans = pq.peek();
              ch.add(ans[1]);
        }
        int[] y = new int[ch.size()];
        for(int i = 0; i < y.length; i++){
            y[i] = ch.get(i);
        }
        return y;
    }
}