/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> x = new ArrayList<>();
    int m = 0;
   
    public NestedIterator(List<NestedInteger> nestedList) {
        generateLidt(nestedList);
    }
    void generateLidt(List<NestedInteger> o){
        for(NestedInteger j : o){
            if(j.isInteger()){
               
                x.add(j.getInteger());
            }
            else{
                generateLidt(j.getList());
            }
        }
    }
    @Override
    public Integer next() {
     m++;
     return x.get(m -1);
    }

    @Override
    public boolean hasNext() {
        if(m < x.size()){
            return true;
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */