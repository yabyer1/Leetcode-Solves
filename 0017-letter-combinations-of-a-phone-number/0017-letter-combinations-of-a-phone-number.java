class Solution {
    public List<String> letterCombinations(String digits) {
        
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        String ok = "";
        fidn(hm, res, digits, 0, ok );
        return res;
    }
    void fidn(HashMap<Character, String> hm, List<String> res, String digits, int index, String cur){
        if(index >= digits.length()){
            
            res.add(cur);
            return;
        }
        for(int i = 0; i < hm.get(digits.charAt(index)).length(); i++){
            String temp = cur;
            temp += hm.get(digits.charAt(index)).charAt(i);
            fidn(hm, res, digits, index + 1, temp);
        }

    }
}