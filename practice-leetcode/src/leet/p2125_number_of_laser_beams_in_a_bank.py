from typing import List

class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        total = 0
        security_devices_on_each_row = []

        for row in bank:
            number_of_security_devices = row.count("1")
            if number_of_security_devices != 0:
                security_devices_on_each_row.append(number_of_security_devices)
            
        rows_with_devices = len(security_devices_on_each_row)
        
        for i in range (0, rows_with_devices - 1):
            total += security_devices_on_each_row[i] * security_devices_on_each_row[i+1]

        return total

if __name__ == "__main__":
    sol = Solution()

    print(sol.numberOfBeams(["011001","000000","010100","001000"]))
    print(sol.numberOfBeams(["000","111","000"]))