class Solution {
    public int findCoverage(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Use a single array of size N. 
        // Even number = only zeroes seen so far (value / 2 = count of zeroes)
        // Odd number = a 1 has been seen (value / 2 = count of zeroes since the last 1)
        int[] mem = mat[0]; // Reference, not initialization still O(1)
        int result = 0;

        for (int x = 0; x < m; x++) {
            boolean seenRowOne = false;
            int rowZeroes = 0;
            
            for (int y = 0; y < n; y++) {
                int data = mat[x][y];
                
                if (data == 0) {
                    rowZeroes++;
                    if (seenRowOne) result++; 
                    
                    if ((mem[y] & 1) == 1) result++; 
                    mem[y] += 2;                     
                } else {
                    seenRowOne = true;
                    result += rowZeroes; 
                    rowZeroes = 0;
                    
                    result += mem[y] >> 1; 
                    mem[y] = 1;            
                }
            }
        }

        return result;
    }
}