class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;

        for(int i = 0; i < words.length; i++){
            count += (isExpress(s, words[i]));
        }
        return count;
        /*
        Map<Character,Integer> freqMap = new HashMap<>();
        Set<Character> hs = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
            hs.add(s.charAt(i));
        }
        for(int i = 0; i < words.length; i++){
            Map<Character, Integer> cm = new HashMap<>();
            Set<Character> nh = new HashSet<>();
            boolean flag = true;
            for(int j = 0; j < words[i].length(); j++){
                cm.put(words[i].charAt(j), cm.getOrDefault(words[i].charAt(j), 0) + 1);
                if(!hs.contains(words[i].charAt(j))){
                    flag = false;
                }
                nh.add(words[i].charAt(j));
            }
            for(int x  = 0; x < s.length(); x++){
                if(!nh.contains(s.charAt(x))){
                    flag = false;
                }
            }
            if(flag){
            for (Map.Entry<Character,Integer> me : cm.entrySet()) {
            char key = me.getKey();
 
            // Adding some bonus marks to all the students
            int value = (me.getValue());
 
            // Printing above marks corresponding to
            // students names
            //System.out.println(key + " : " + value);
            /*
            if(value > freqMap.get(key) || (value + 1 == freqMap.get(key)) ){
                flag = false;
            }
        }
            }
            if(flag){
                System.out.println(words[i]);
            count++;
            }
        }
        return count;
        */
    }
    int isExpress(String key, String word){
        int i = 0;
        int j = 0;
        if(key.charAt(i) != word.charAt(j)){
          
            return 0;
        }
        while(i < key.length() && j < word.length()){
         // System.out.println(i + "   " + j);
        
          if( i < key.length() && j < word.length() &&  key.charAt(i) == word.charAt(j)){
                 int ICount = 1;
          int   JCount = 1;
          while(i < key.length() - 1 && key.charAt(i) == key.charAt(i + 1)){
              ICount += 1;
              i++;
              //  System.out.println(word + " " + ICount + "   " + i);
          }
             while(j < word.length() - 1 && word.charAt(j) == word.charAt(j + 1)){
                 JCount += 1;
              j++;
                              // System.out.println(word + " " + ICount + "   " + JCount);

          }
          if( (ICount < 3 || ICount < JCount) && ICount != JCount){
            
              return 0;
          }
          }
          else{
              return 0;
          }
          i++;
          j++;
         
        }
        if(i < key.length() && j < word.length() && key.charAt(i) == word.charAt(j)){
            i++;
            j++;
        }
        if(i == key.length() && j == word.length())
        return 1;
        return 0;
    }
}