class Solution {
    public void replaceElements(int[] arr) {
        // code here
        int prev=arr[0];
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            arr[i-1]^=arr[i];
            arr[i]=prev;
            prev=temp;
        }
        arr[arr.length-1]^=prev;
    }
}