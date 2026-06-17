class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        parents = [-1] * n
        ranks = [-1] * n

        def find(index: int):
            if parents[index] == -1:
                return index

            p = find(parents[index])
            parents[index] = p
            return p

        for edge in edges:
            node = edge[0]
            nbr  = edge[1]

            p1 = find(node)
            p2 = find(nbr)

            if p1 != p2:
                if ranks[p1] < ranks[p2]:
                    ranks[p2] += ranks[p1]
                    parents[p1] = p2
                else:
                    ranks[p1] += ranks[p2]
                    parents[p2] = p1
        count = 0
        for num in parents:
            if num == -1:
                count += 1
        return count