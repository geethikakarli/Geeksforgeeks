import java.util.*;

class Solution {
    public static int longestKSubstr(String s, int k) {
        int left = 0, max = -1;
        Map<Character,Integer> map = new HashMap<>();

        for(int right=0; right<s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);

            while(map.size() > k){
                char c = s.charAt(left);
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) map.remove(c);
                left++;
            }

            if(map.size() == k)
                max = Math.max(max, right-left+1);
        }
        return max;
    }
}