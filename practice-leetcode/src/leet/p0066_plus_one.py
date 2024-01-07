from typing import List

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        number = int(''.join(map(str, digits))) + 1
        return [int(d) for d in str(number)]

if __name__ == '__main__':
    sol = Solution()

    print(sol.plusOne([1, 2, 3]))
    print(sol.plusOne([4, 3, 2, 1]))
    print(sol.plusOne([9]))