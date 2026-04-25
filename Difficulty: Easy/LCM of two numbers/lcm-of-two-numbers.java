class Solution {
    public int lcm(int a, int b) {
        // code here
        // Larger value
        int g = Math.max(a, b); 
        
        // Smaller value
        int s = Math.min(a, b);

        for (int i = g; i <= a * b; i += g) {
            if (i % s == 0)
                return i;
        }
        return a * b; 
    
    }
}