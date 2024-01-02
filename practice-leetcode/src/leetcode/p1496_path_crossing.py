class Solution:
    def isPathCrossing(self, path: str) -> bool:
        current_x, current_y = 0, 0
        visited_coordinates = {(0,0)}

        for p in path:
            match p:
                case "N": current_x += 1
                case "S": current_x -= 1
                case "E": current_y += 1
                case "W": current_y -= 1
                
            if (current_x, current_y) in visited_coordinates:
                return True
            else:
                visited_coordinates.add((current_x, current_y))
        
        return False

if __name__ == '__main__':
    sol = Solution()
    
    print(sol.isPathCrossing("NES"))
    print(sol.isPathCrossing("NESWW"))
    print(sol.isPathCrossing("NNESWWS"))