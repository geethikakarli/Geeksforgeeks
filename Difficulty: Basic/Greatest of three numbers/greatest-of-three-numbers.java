class Solution {
    public int greatestOfThree(int a, int b, int c) {
        
        List<Integer> nums = List.of(a,b,c);
        
        int temp = Integer.MIN_VALUE;
        
        for(Integer num : nums) {
            
            if(num > temp) {
                temp = num;
            }
            
        }
        
        return temp;
    
        
    }
}
