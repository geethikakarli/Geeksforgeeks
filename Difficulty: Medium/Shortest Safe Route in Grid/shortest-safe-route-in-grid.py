class Solution:
    def shortestPath(self, mat: list[list[int]]) -> int:
           from collections import deque
           DXDY = [(-1, 0), (0, 1), (1, 0), (0, -1)]
           m, n = len(mat), len(mat[0])
           # mark cells around landmines
           for x in range(m):
               for y in range(n):
                   if mat[x][y] == 0:
                       for dx, dy in DXDY:
                           x1, y1 = x + dx, y + dy
                           if 0 <= x1 < m and 0 <= y1 < n and mat[x1][y1] == 1:
                               mat[x1][y1] = 2
           # initialise the queue with safe first column's cells
           q = deque((x, 0) for x in range(m) if mat[x][0] == 1)
           if n == 1 and q:
               # the first column is the last column
               return 1
           for steps in range(2, m * n):
               for _ in range(len(q)):
                   x, y = q.popleft()
                   for dx, dy in DXDY:
                       x1, y1 = x + dx, y + dy
                       if 0 <= x1 < m and 0 <= y1 < n and mat[x1][y1] == 1:
                           if y1 == n - 1:
                               return steps
                           mat[x1][y1] = -1
                           q.append((x1, y1))
               if not q:
                   break
           return -1
        