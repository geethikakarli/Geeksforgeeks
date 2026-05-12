class Solution {
    int missingNum(int arr[]) {
        int xor=0;
        for(int i=0; i <arr.length ; ++i)
        {
            xor^=(i+1)^arr[i];
        }
        return xor^(arr.length+1);
    }
}