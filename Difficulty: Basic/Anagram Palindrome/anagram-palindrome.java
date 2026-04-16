class Solution {
    boolean canFormPalindrome(String s) {
        
        HashMap<Character,Integer>mp=new HashMap<>();
        for(char c:s.toCharArray())
        {
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        int oddcount=0;
        for(int freq:mp.values())
        {
            if(freq%2!=0)
            {
                oddcount++;
            }
        }
        return oddcount<=1;
    }
}