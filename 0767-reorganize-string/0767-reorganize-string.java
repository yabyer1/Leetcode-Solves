class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        String check = "";
        for(int i = 0; i < s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>( (a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<Character,Integer> x : hm.entrySet()){
         
            pq.add(new Pair<>(x.getKey(), x.getValue()));
        }
        Character old = Character.MIN_VALUE;
        int i = 0;
        while(i <= s.length() - 1){
            Pair<Character,Integer> z = pq.remove();
           
            Integer  oldFreq = z.getValue();
            Character nxt = z.getKey();
            if(!nxt.equals(old)){
               
                check += nxt;
                if(oldFreq > 1)
                pq.add(new Pair<>(nxt, oldFreq - 1));
                 
            }
            else{
                if(pq.isEmpty()){
                    return "";
                }
                
                 Pair<Character,Integer> y = pq.remove();
            Integer  oldFreq2 = y.getValue();
            Character nxt2 = y.getKey();
            check+= nxt2;
           
                if(oldFreq2 > 1)
                pq.add(new Pair<>(nxt2, oldFreq2 - 1));
                 pq.add(new Pair<>(nxt, oldFreq));
            }
            old = check.charAt(check.length() - 1);
             //System.out.println(nxt + " " + old + " ");
            i++;
        }
        return check;
    }
}