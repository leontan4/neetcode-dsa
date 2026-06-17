class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        directions = [(0,1),(1,0),(-1,0),(0,-1)]
        m = len(grid)
        n = len(grid[0])
        max_area = 0
        LAND = 1
        WATER = 0

        def isValid(r: int, c: int):
            if min(r, c) < 0 or r >= m or c >= n or grid[r][c] == WATER:
                return False
            return True

        def dfs(r: int, c: int):
            area = 1
            grid[r][c] = WATER

            for dx, dy in directions:
                x = r + dx
                y = c + dy

                if isValid(x, y):
                    area += dfs(x, y)

            return area

        for r in range(m):
            for c in range(n):
                if grid[r][c] == LAND:
                    max_area = max(max_area, dfs(r, c))

        return max_area