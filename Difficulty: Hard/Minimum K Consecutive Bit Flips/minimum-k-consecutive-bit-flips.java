class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length, flips = 0, ans = 0;
        int[] flip = new int[n];

        for(int i = 0; i < n; i++){
            if(i >= k) flips ^= flip[i - k];

            if((arr[i] ^ flips) == 0){
                if(i + k > n) return -1;
                ans++;
                flips ^= 1;
                flip[i] = 1;
            }
        }
        return ans;
    }
}