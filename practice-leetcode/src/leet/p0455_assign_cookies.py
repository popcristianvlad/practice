from typing import List

class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()

        sizeOfG = len(g)
        sizeOfS = len(s)
        i, j = 0, 0
        fedChildren = 0

        while i < sizeOfG and j < sizeOfS:
            if g[i] > s[j]:
                j += 1
            else:
                fedChildren += 1
                i += 1
                j += 1
        
        return fedChildren

if __name__ == '__main__':
    sol = Solution()

    print(sol.findContentChildren([1, 2, 3], [1, 1]))
    print(sol.findContentChildren([1, 2], [1, 2, 3]))
    print(sol.findContentChildren([1, 2], []))
    print(sol.findContentChildren([10, 9, 8, 7], [5, 6, 7, 8]))