class Solution {
    class UF{
          int[] parent;
       public UF(int n){
           parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        int find(int n){
            if(parent[n] == n){
                return n;
            }
           return find(parent[n]);
        
        }
        boolean union(int x1, int y1){
            int x2 = find(x1);
            int y2 = find(y1);
            if(x2 == y2){
                return false;
            }
            else{
                parent[y2] = x2;
                return true;
            }
        }
        void print(){
            for(int y : parent){
                System.out.println(y);
            }
        }
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashSet<Integer> Nodes = new HashSet<>();
        UF uf = new UF(n);
        for(int i = 0; i < n; i++){
            if(leftChild[i] != -1){
                if(!uf.union(i, leftChild[i])){
                    return false;
                }
                if(Nodes.contains(leftChild[i])){
                    return false;
                }
                Nodes.add(leftChild[i]);
            }
               if(rightChild[i] != -1){
                     if(!uf.union(i, rightChild[i])){
                    return false;
                }
                if(Nodes.contains(rightChild[i])){
                    return false;
                }
                Nodes.add(rightChild[i]);
            }

        }
        //uf.print();
        if(Nodes.size() == n -1){
            return true;
        }
        return false;
    }
}