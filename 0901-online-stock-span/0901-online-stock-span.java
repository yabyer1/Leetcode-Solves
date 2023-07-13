class StockSpanner {
        Stack<Pair<Integer,Integer>> x = new Stack<>();
        int curCount = 0;
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int num = 1;
        while(!x.isEmpty() && price >= x.peek().getKey()){
          num+= x.peek().getValue();
          x.pop();
        }
        x.push(new Pair<>(price, num));
        return num;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */