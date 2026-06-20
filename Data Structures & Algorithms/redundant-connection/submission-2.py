class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges) + 1
        parents = [-1] * n
        ranks = [1] * n


        def find(index):
            if parents[index] == -1:
                return index

            p = find(parents[index])
            parents[index] = p
            return p

        res = []
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

            if p1 == p2:
                return edge
        return res
