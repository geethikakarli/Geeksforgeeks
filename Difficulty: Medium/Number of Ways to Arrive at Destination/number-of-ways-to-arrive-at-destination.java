import java.util.*;

class Solution {
    public int countPaths(int n, int[][] edges) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int[] e : edges) {
            g.get(e[0]).add(new int[]{e[1], e[2]});
            g.get(e[1]).add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];

            if (d > dist[u]) continue;

            for (int[] nei : g.get(u)) {
                int v = nei[0];
                long wt = nei[1];

                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    ways[v] = ways[u];
                    pq.add(new long[]{dist[v], v});
                } else if (d + wt == dist[v]) {
                    ways[v] += ways[u];
                }
            }
        }

        return ways[n - 1];
    }
}