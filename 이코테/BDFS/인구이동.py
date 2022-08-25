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
    united = []
    visited = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j]:
                continue
            nations_group = []
            q.append((i,j))
            while q:
                x, y = q.pop()
                if visited[x][y] :
                    continue
                visited[x][y] = True
                nations_group.append((x, y)) # 여기서 문제임
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or ny < 0 or nx >= n or ny >= n:
                        continue
                    if visited[nx][ny] or abs(nations[x][y] - nations[nx][ny]) < l or abs(nations[x][y] - nations[nx][ny]) > r:
                    # if visited[nx][ny]:
                        continue
                    q.append((nx,ny))
            united.append(nations_group)
    return united

days = 0
united_list = makeUnions()
while len(united_list) > 0 and days < 5:
    print(len(united_list))
    for united in united_list:
        print(united)
        length = len(united)
        population = 0
        for x, y in united:
            population += nations[x][y]
        for x, y in united:
            nations[x][y] = population // length

    days += 1
    united_list = makeUnions()
