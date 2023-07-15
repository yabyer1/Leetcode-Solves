class Solution {
    public int maxEvents(int[][] events) {
        /*
        Arrays.sort(events, (a, b) -> {
    int c1 = a[1];
    int c2 = b[1];
    if (c1 == c2) return Integer.compare(a[0], b[0]);
    return Integer.compare(c1, c2);
});
*/
Arrays.sort(events, Arrays::compare);
/*
for(int[] g : events){
    System.out.println(g[0] + "    " + g[1]);
}
*/
int ans = 0;
//int LastDay = events[events.length - 1][1];
int day = 0;
int j = 0;
PriorityQueue<Integer> pq = new PriorityQueue<>();
/*
  for(int i = 1; i <= LastDay; i++){
      if(j > events.length - 1){
          break;
      }
      if(events[j][0] <= i && events[j][1] >= i){
          ans++;
          j++;
      }
      else if(events[j][0] > i){
                continue;
      }
      else{
          j++;
      }
  }
  */
  while(j < events.length || !pq.isEmpty()){
        if(pq.size() == 0){
          //  pq.add(events[i][1]);
          day = events[j][0];
        }
        while( j < events.length && day == events[j][0]){
            pq.add(events[j][1]);
            j++;
        }
        pq.remove();
        day++;
        ans++;
        while(!pq.isEmpty() && pq.peek() < day){
            pq.remove();
        }
  }
        return ans;
    }
}