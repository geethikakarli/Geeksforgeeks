class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        int n = mat.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int d = 0; d < 2 * n - 1; d++) {
            for (int i = 0; i < n; i++) {
                int j = d - i;
                if (j >= 0 && j < n) {
                    res.add(mat[i][j]);
                }
            }
        }

        return res;
    }
}