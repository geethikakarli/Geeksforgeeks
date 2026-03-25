import java.util.*;

class Solution {
    public ArrayList<Integer> minHeightRoot(int n, int[][] edges) {
        if (n == 1) return new ArrayList<>(Arrays.asList(0));

        List<Set<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new HashSet<>());

        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (g.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int neighbor = g.get(leaf).iterator().next();
                g.get(neighbor).remove(leaf);
                if (g.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}