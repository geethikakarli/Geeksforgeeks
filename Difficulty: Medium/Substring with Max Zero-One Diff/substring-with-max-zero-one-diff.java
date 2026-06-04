class Solution {
    int maxSubstring(String s) {
        // code here
        int sum = 0;
        int maxSum = 0;
        boolean zeroPresent = false;
        for(char ch : s.toCharArray()) {
            int x = ch-'0';
            
            if(x == 1) {
                sum-=1;
            } else {
                sum+=1;
                zeroPresent = true;
            }
            
            if (sum < 0) {
                sum = 0;
            }
            
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        
        if(!zeroPresent) {
            return -1;
        }
        
        return maxSum;
    }
}