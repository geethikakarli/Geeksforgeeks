class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        boolean[] check = new boolean [end+1];
        
        // Marking from array
        for(int val: arr) {
            if(val >= start && val <= end) {
                check[val] = true;
            }
        }
        
        // Checking range
        for(int i = start; i <= end; i++) {
            if(check[i] == false) {
                return false;
            }
        }
        
        return true;
    }
}