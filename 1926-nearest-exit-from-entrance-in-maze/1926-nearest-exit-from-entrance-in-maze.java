class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0 , -1}, {-1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] visited = new int[maze.length][maze[0].length];
     Queue<Pair<Integer, Integer>> BFS = new LinkedList<>();
        BFS.offer(new Pair<>(entrance[0], entrance[1]));
        visited[entrance[0]][entrance[1]] = 1;
        int steps = 0;
       while(!BFS.isEmpty()){
               Queue<Pair<Integer, Integer>> temp = new LinkedList<>();
             while(!BFS.isEmpty()){
            Pair p1 = BFS.poll();
            Integer i = (Integer) p1.getKey();
            Integer j = (Integer) p1.getValue();
         
            if(i.equals(0) || i.equals(maze.length - 1) || j.equals(0) || j.equals(maze[maze.length - 1].length - 1)){
           if(i.equals(entrance[0]) && j.equals(entrance[1])){
               
           } 
           else{
                   return steps;
           }
            }
            for(int[] dir : directions){
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if(nextJ < 0 || nextI < 0 || nextI >= maze.length || nextJ >= maze[0].length || maze[nextI][nextJ] == '+' || visited[nextI][nextJ] == 1){
                    continue;
                } 
                visited[nextI][nextJ] = 1; 
                //System.out.println(nextI + " " + nextJ + "         "); 
                temp.offer(new Pair<>(nextI, nextJ));
            }
           // System.out.println();
           
         
             }
            BFS = temp;
             steps++;
       }

        return -1;
        
    }
}