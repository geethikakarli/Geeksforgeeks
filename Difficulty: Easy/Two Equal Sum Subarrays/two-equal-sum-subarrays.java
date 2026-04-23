class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int n = arr.length;
        int[] psum = new int[n];
        psum[0] = arr[0];
        for(int i=1;i<n;i++) psum[i] = psum[i-1]+arr[i];
        int val = psum[n-1];
        if(val%2==0){
        for(int i=0;i<n;i++){
            if(psum[i] == val/2) {
                return true;
            }
        }
    }
    return false;
    }
}