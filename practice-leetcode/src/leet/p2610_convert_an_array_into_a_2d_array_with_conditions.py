from typing import List

class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        matrix = [[nums[0]]]
        for current_num in nums[1:]:
            appended = False
            for arr in matrix:
                if not arr.__contains__(current_num) and not appended:
                    arr.append(current_num)
                    appended = True
            if not appended:
                matrix.append([current_num])

        return matrix

if __name__ == "__main__":
    sol = Solution()

    print(sol.findMatrix([1, 3, 4, 1, 2, 3, 1]))
    print(sol.findMatrix([1, 2, 3, 4]))