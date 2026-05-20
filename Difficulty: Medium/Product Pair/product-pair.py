class Solution:
    def isProduct(self, arr, target):
        seen = set()
        for num in arr:
            if target == 0 and num == 0:
                return True
            if num != 0 and target % num == 0:
                if target // num in seen:
                    return True
            seen.add(num)
        return False

def main():
    arr = [10, 20, 9, 40]
    target = 400
    ob = Solution()
    ans = ob.isProduct(arr, target)   # ✅ matches signature now
    print(ans)