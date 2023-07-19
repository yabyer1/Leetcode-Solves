class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        /*
        for(int i = 0; i < intervals.length; i++){
           System.out.println(intervals[i][0] + "    " + intervals[i][1]);
        }
        */
        int ans = 0;
        int prev = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= intervals[prev][1]){
                prev = i;
                continue;
            }
           // System.out.println(intervals[i][0] + " " + intervals[i-1][1]);
            ans++;
        }
        return ans;
    }
}