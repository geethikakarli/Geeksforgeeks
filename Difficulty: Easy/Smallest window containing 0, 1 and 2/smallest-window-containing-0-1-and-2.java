class Solution {
    public int smallestSubstring(String s) {
        // Code here
        int[] freq = new int[3];
        int minLength = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < s.length(); r++){
            if(s.charAt(r)=='0')
                freq[0]++;
            else if(s.charAt(r)=='1')
                freq[1]++;
            else 
                freq[2]++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                minLength = Math.min(minLength, r - l + 1);

                freq[s.charAt(l) - '0']--;
                l++;
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
};