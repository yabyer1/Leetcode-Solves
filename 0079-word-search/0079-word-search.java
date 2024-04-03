class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
       // 
        for(int i = board.length - 1; i > - 1; i--){
            for(int j = board[i].length - 1; j > -1; j--){
                if(board[i][j] == word.charAt(0)){
                 HashSet<Integer> hs = new HashSet<>();
                 hs.add(i * board[0].length + j);
                  if (DFS(i, j, board, word, 1, hs)){
                    return true;
                  }
                }
            }
        }
        return false;
    }
   boolean DFS(int i, int j, char[][] board, String word, int c, HashSet<Integer> hs){
   
                if(c >= word.length()){
                     
                    return true;
                }
           
            // HashSet<Integer> hs = new HashSet<>(bs);
            boolean FoundNxt = false;
            for(int[] dirs : dir){
                int newI = dirs[0] + i;
                int newJ = dirs[1] + j;
                if(newI < 0 || newI > board.length - 1 || newJ < 0 || newJ > board[newI].length - 1){
                        continue;
                }
                         
                if(word.charAt(c) == board[newI][newJ] && !hs.contains(newI * (board[0].length) + newJ)){
                    HashSet<Integer> bs = new HashSet<>(hs);
                    bs.add(newI * (board[0].length) + newJ);
                  
                    FoundNxt |= DFS(newI, newJ,board,  word, c+ 1, bs);
                    bs.remove(newI * (board[0].length)+ newJ);
                }
            }
          //  System.out.println();
           return FoundNxt;
   }
    boolean BFS(int i , int j, char[][] board, String word, int c){
        Queue<int[]> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        Queue<HashSet<Integer>> backtrack = new LinkedList<>();
        int[] first = new int[2];
        first[0] = i; first[1] = j;
        int cur = c;
        int coord = i * board.length + j;
        hs.add(coord);
        q.add(first);
        backtrack.add(hs);
        //board[i][j] = '!';
        while(!q.isEmpty()){
            int size = q.size();
            cur++;
            if(cur == word.length()){
                return true;
            }
            boolean foundNxt = false;
            while(size-- > 0){
                int[] coords = q.remove();
                HashSet<Integer> curPath =  backtrack.remove();
                int x = coords[0];
                int y = coords[1];
                hs.add(x * board[0].length + y);
                for(int[] dirs : dir){
                    int newX = x + dirs[0];
                    int newY = y + dirs[1];
                    if(0 > newX || 0 > newY || newX > board.length - 1 || newY>= board[0].length ){
                        continue;
                    }
                       int amnt = newX * board[0].length + newY;
                    if(board[newX][newY] == word.charAt(cur) && !curPath.contains(amnt)){
                        HashSet<Integer> nxp = new HashSet<>(curPath);
                        nxp.add(amnt);
                        backtrack.add(nxp);
                        int[] s = new int[2];
                        s[0] = newX;
                        s[1] = newY;
                        q.add(s);
                       // board[newX][newY] = '!';
                        foundNxt = true;
                      
                       // hs.add(amnt);
                    }
               
                }
            }
            if(!foundNxt){
                return false;
            }
        }
        return false;
    }
}