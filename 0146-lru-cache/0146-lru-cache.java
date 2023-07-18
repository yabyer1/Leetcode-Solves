class LRUCache {
    LinkedHashMap<Integer,Integer> LRU;
    int size;
 //  ArrayList<Integer> LU = new ArrayList<Integer>();
    public LRUCache(int capacity) {
        size = capacity;
          LRU = new LinkedHashMap<>(capacity, 1f, true){
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e)
            {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        /*
        if(LRU.containsKey(key)){
            if(LU.indexOf(key) != -1){
                LU.remove(LU.indexOf(key));
            }
            LU.add(key);
            return LRU.get(key);
        }
        */
           if(LRU.containsKey(key)){
               // LRU.put(key, LRU.get(key));
            return LRU.get(key);
           }
        return -1;
 
    }
    
    public void put(int key, int value) {
        /*
        LRU.put(key, value);
          if(LU.indexOf(key) != -1){
                LU.remove(LU.indexOf(key));
            }
            LU.add(key);
        if(LRU.size() > size){
            LRU.remove(LU.get(0));
            LU.remove(0);
        }
     */
       LRU.put(key, value);
       /*
       if(LRU.size() > size){
            LRU.removeEldestEntry();
            
        }
        */
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */