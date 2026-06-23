class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        directions = [(0,1),(0,-1),(1,0),(-1,0)]
        m = len(grid)
        n = len(grid[0])

        ROTTEN = 2
        ORANGE = 1
        EMPTY = 0

        def isValid(r, c):
            if min(r, c) < 0 or r >=m or c >= n or grid[r][c] != ORANGE:
                return False
            return True

        def bfs(dq):
            minutes = -1

            while dq:
                for _ in range(len(dq)):
                    path = dq.popleft()
                    row = path[0]
                    col = path[1]
                    
                    for dx, dy in directions:
                        x = dx + row
                        y = dy + col

                        if isValid(x, y):
                            grid[x][y] = ROTTEN
                            dq.append([x, y])
                minutes += 1
            return minutes
        
        dq = deque()
        
        for r in range(m):
            for c in range(n):
                if grid[r][c] == ROTTEN:
                    dq.append([r, c])
        
        minutes = bfs(dq)

        for r in range(m):
            for c in range(n):
                if grid[r][c] == ORANGE:
                    return -1

        return 0 if minutes == -1 else minutes