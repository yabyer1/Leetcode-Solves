class Solution {
    int LetsCheck;
    boolean checkAll = true;
    public boolean isBipartite(int[][] graph) {
        char[] visited = new char[graph.length];
        visited[0] = 'R';
        for(int i = 0; i < graph[0].length; i++){ 
         DFS(graph, visited[0], visited, graph[0][i]);
          if(checkAll == false){
              return false;
          }
        }
        while(!isFilled(visited)){
            visited[LetsCheck] = 'R';
              for(int i = 0; i < graph[LetsCheck].length; i++){ 
         DFS(graph, visited[LetsCheck], visited, graph[LetsCheck][i]);
          if(checkAll == false){
              return false;
          }
        }

        }
        return true;
    }
    boolean isFilled(char[] graph){
        for(int i = 0; i < graph.length; i++){
            if(graph[i] == '\0'){
                LetsCheck = i;
                return false;
            }
        }
        return true;
    }
    void DFS(int[][] graph, char lastColor, char[] visited, int index){
            char CurColor;
            if(lastColor == 'R'){
               CurColor = 'B';

            }
            else{
                CurColor = 'R';
            }
            if((CurColor == 'R' && visited[index] == 'B') || (CurColor == 'B' && visited[index] == 'R')){
                checkAll = false;
                return;
            }
            else if(CurColor == visited[index]){
                return;
            }
            visited[index] = CurColor;
        for(int i = 0; i < graph[index].length; i++){
                DFS(graph, CurColor, visited, graph[index][i]);
        }
    }

}