class Solution:
    def articulationPoints(self, V, edges):
        
        import sys
        sys.setrecursionlimit(10**7)

        adj = [[] for _ in range(V)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        tin = [-1] * V
        low = [-1] * V
        vis = [False] * V
        mark = [False] * V

        timer = [0]

        def dfs(node, parent):
            vis[node] = True
            tin[node] = low[node] = timer[0]
            timer[0] += 1
            child = 0

            for nei in adj[node]:
                if nei == parent:
                    continue

                if not vis[nei]:
                    dfs(nei, node)
                    low[node] = min(low[node], low[nei])

                    if low[nei] >= tin[node] and parent != -1:
                        mark[node] = True

                    child += 1
                else:
                    low[node] = min(low[node], tin[nei])

            if parent == -1 and child > 1:
                mark[node] = True

        for i in range(V):
            if not vis[i]:
                dfs(i, -1)

        res = [i for i in range(V) if mark[i]]
        return res if res else [-1]