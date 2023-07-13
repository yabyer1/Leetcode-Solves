class SmallestInfiniteSet {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int EmptyCalls = 0;
    public SmallestInfiniteSet() {
        
    }
    
    public int popSmallest() {
        if(pq.isEmpty()){
            EmptyCalls++;
            return EmptyCalls;
        }
        if(pq.peek() < EmptyCalls + 1){
            return pq.remove();
        }
        EmptyCalls++;
        return EmptyCalls;
    }
    
    public void addBack(int num) {
        if(num < EmptyCalls + 1 && !pq.contains(num)){
        pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */