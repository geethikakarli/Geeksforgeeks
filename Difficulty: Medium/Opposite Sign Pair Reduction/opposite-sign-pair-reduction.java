import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int num : arr) {
            boolean add = true;
            
            while (!res.isEmpty()) {
                int last = res.get(res.size() - 1);
                
                // Check opposite signs
                if ((last >= 0 && num < 0) || (last < 0 && num >= 0)) {
                    
                    if (Math.abs(last) > Math.abs(num)) {
                        // last survives
                        add = false;
                        break;
                    } else if (Math.abs(last) < Math.abs(num)) {
                        // current survives, remove last
                        res.remove(res.size() - 1);
                        continue;
                    } else {
                        // equal → both removed
                        res.remove(res.size() - 1);
                        add = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            
            if (add) {
                res.add(num);
            }
        }
        
        return res;
    }
}