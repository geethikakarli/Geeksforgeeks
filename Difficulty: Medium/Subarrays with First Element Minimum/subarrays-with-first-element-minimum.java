import java.util.*;

class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[i] <= arr[st.peek()])
                st.pop();

            if(st.isEmpty())
                ans += n - i;
            else
                ans += st.peek() - i;

            st.push(i);
        }
        return ans;
    }
}