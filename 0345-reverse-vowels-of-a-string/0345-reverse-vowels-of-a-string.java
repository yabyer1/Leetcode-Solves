class Solution {
    public boolean isVowel(char c)
{
    if(c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' ||     c=='u' || c=='U')
    {    
        return true;
    }    
    else
    {
        return false;
    }    
}

    public String reverseVowels(String g) {
        int x  = 0;
      
        char[] s = g.toCharArray();
      
          int y = s.length - 1;
        while(x < y){
           if(isVowel(s[x]) && isVowel(s[y])){
                    char temp = s[x];
                    s[x] = s[y];
                    s[y] = temp;
                    x++;
                    y--;
                }
                while(!isVowel(s[x]) && x < y){
                    x++;
                }
                  while(!isVowel(s[y]) && x < y){
                    y--;
                }
            
        }
        return String.valueOf(s);
    }
}