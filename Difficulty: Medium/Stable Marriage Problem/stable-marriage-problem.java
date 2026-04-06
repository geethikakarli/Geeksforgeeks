import java.util.*;

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;

        int[] wife = new int[n];     // woman → man
        int[] husband = new int[n];  // man → woman
        int[] next = new int[n];     // next proposal index

        Arrays.fill(wife, -1);
        Arrays.fill(husband, -1);

        // ranking: woman preference
        int[][] rank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) q.add(i);

        while (!q.isEmpty()) {
            int m = q.poll();
            int w = men[m][next[m]++];

            if (wife[w] == -1) {
                wife[w] = m;
                husband[m] = w;
            } else {
                int m2 = wife[w];
                if (rank[w][m] < rank[w][m2]) {
                    wife[w] = m;
                    husband[m] = w;
                    husband[m2] = -1;
                    q.add(m2);
                } else {
                    q.add(m);
                }
            }
        }

        return husband;
    }
}