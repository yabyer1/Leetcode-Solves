class Solution {
    public int maxVowels(String s, int k) {
        ArrayList<Character> vowelList = new ArrayList<>();
        vowelList.add('a');
        vowelList.add('e');
        vowelList.add('i');
        vowelList.add('o');
        vowelList.add('u');
        int maxVowels = 0;
        for(int i = 0; i < k; i++){
            if(vowelList.contains(s.charAt(i))){
                maxVowels++;
            }
        }
        // System.out.println(maxVowels);
        int TempVowels = maxVowels;
        for(int i = k; i < s.length(); i++){
            if(vowelList.contains(s.charAt(i - k))){
               TempVowels--;
            }
            if(vowelList.contains(s.charAt(i))){
               TempVowels++;
            }
           
            maxVowels = Math.max(TempVowels, maxVowels);
        }
        return maxVowels;
    }
}