class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        StringBuilder one = new StringBuilder(s1);
        StringBuilder two = new StringBuilder(s2);
        int[][] dp = new int[s1.length()][s2.length()];
        return find(one, two, dp, 0, 0);
    }

    int find(StringBuilder s1, StringBuilder s2, int[][] dp, int i, int j) {
      //  System.out.println(s1.toString() + " " + s2.toString() + " " + i + " " + j);
        if (i == s1.length() && j == s2.length()) {
            return 0;
        }
        if (i == s1.length()) {
            int sum = 0;
            while (j < s2.length()) {
                sum += s2.charAt(j);
                j++;
            }
            return sum;
        }
        if (j == s2.length()) {
            int sum = 0;
            while (i < s1.length()) {
                sum += s1.charAt(i);
                i++;
            }
            return sum;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int res = Integer.MAX_VALUE;
        char x = s1.charAt(i);
        char y = s2.charAt(j);

        if (x == y) {
            res = Math.min(find(s1, s2, dp, i + 1, j + 1), res);
        } else {
            res = Math.min(find(s1, s2, dp, i + 1, j) + (int) x, find(s1, s2, dp, i, j + 1) + (int) y);
        }

        dp[i][j] = res; 
        return res;
    }
}
