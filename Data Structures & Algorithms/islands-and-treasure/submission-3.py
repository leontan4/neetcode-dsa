class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        directions = {(0, 1),(0, -1),(1, 0),(-1, 0)}
        m = len(grid)
        n = len(grid[0])

        WATER = -1
        CHEST = 0
        LAND = 2147483647

        def isValid(r, c):
            if min(r, c) < 0 or r >= m or c >= n or grid[r][c] != LAND:
                return False
            return True

        def bfs(dq):
            
            while dq:
                size = len(dq)
                path = dq.popleft()
                row = path[0]
                col = path[1]

                for dx, dy in directions:
                    x = dx + row
                    y = dy + col

                    if isValid(x, y):
                        if grid[x][y] > grid[row][col] + 1:
                            grid[x][y] = grid[row][col] + 1
                            dq.append([x, y])

        
        dq = deque()

        for r in range(m):
            for c in range(n):
                if grid[r][c] == CHEST:
                    dq.append([r, c])
        
        bfs(dq)