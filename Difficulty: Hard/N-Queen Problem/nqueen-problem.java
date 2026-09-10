class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> helper = new ArrayList<>();
    int n;
    boolean check(int row, int col) {
        for(int p_row = 0; p_row < row; p_row++) {
            int p_col = helper.get(p_row);
            if(p_col == col || Math.abs(row - p_row) == Math.abs(p_col - col)) {
                return false;
            }
        }
        return true;
    }
    void rec(int level) {
        if(level == n) {
            @SuppressWarnings("unchecked")
            ArrayList<Integer> temp = (ArrayList<Integer>) helper.clone();
            ans.add(temp);
            return;
        }

        for(int col = 1; col <= n; col++) {
            if(check(level, col)) {
                helper.add(col);
                rec(level + 1);
                helper.remove(helper.size() - 1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        this.n = n;
        rec(0);
        return ans;
    }
}