class Solution:
    def pairAndSum(self, arr):
           # code here
           ans = 0
           for i in range(31):
               mask = (1<<i)
               cnt = 0
               for e in arr:
                   if e&mask != 0:
                       cnt += 1
               ans += mask*(cnt*(cnt-1))//2
           return ans