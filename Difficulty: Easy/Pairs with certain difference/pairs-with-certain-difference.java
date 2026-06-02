class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int sum = 0, i = n-1;
        while(i>0){
            int diff = arr[i] - arr[i-1];
            if(diff < k){
                sum+=(arr[i]+arr[i-1]);
                i -= 2;
            } else {
                i--;
            }
        }
        return sum;
    }
}