import sys
from collections import deque
input = sys.stdin.readline
n, l , r = map(int, input().split())

nations = []
for _ in range(n):
    nations.append(list(map(int, input().split())))

dirs = [(0,1),(0,-1),(1,0),(-1,0)]
q = deque([])

def makeUnions():
    q.clear()
    united = []
    visited = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            nations_group = []
            q.append((i,j))                
            while q:
                x, y = q.pop()
                if visited[x][y] :
                    continue
                visited[x][y] = True
                nations_group.append((x, y))
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or ny < 0 or nx >= n or ny >= n:
                        continue
                    if visited[nx][ny] or abs(nations[x][y] - nations[nx][ny]) < l or abs(nations[x][y] - nations[nx][ny]) > r:
                        continue
                    q.append((nx,ny))
            if len(nations_group) > 1:
                united.append(nations_group)
    return united

days = 0
united_list = makeUnions()
while len(united_list) > 0:
    for united in united_list:
        length = len(united)
        population = 0
        for x, y in united:
            population += nations[x][y]
        for x, y in united:
            nations[x][y] = population // length

    days += 1
    united_list = makeUnions()

print(days)
