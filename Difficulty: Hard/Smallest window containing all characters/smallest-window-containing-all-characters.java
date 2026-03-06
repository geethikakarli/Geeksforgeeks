import java.util.*;

class Solution {
    public static String minWindow(String s, String p) {
        int[] need = new int[256];
        for(char c : p.toCharArray()) need[c]++;

        int count = p.length(), start = 0, minLen = Integer.MAX_VALUE, startIndex = -1;

        for(int end = 0; end < s.length(); end++) {
            if(need[s.charAt(end)]-- > 0) count--;

            while(count == 0) {
                if(end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    startIndex = start;
                }
                if(++need[s.charAt(start++)] > 0) count++;
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("timetopractice","toc"));
    }
}