from itertools import combinations
from collections import deque
import sys
input = sys.stdin.readline
N, M = map(int, input().split())
lab = []
for _ in range(N):
    lab.append(list(map(int,input().split())))

walls = []
for i in range(N):
    for j in range(M):
        if lab[i][j] == 0:
            walls.append((i, j))

walls_comb = combinations(walls, 3) # 3개 벽의 위치 조합

def build_wall(wall_combination):
    global lab
    new_lab = [[0] * M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            new_lab[i][j] = lab[i][j]

    for wall in wall_combination:
        wx, wy = wall
        new_lab[wx][wy] = 1

    return new_lab

def spread_virus(lab):
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]

    q = deque()
    visited = [[False] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if lab[i][j] != 2:
                continue
            q.append((i,j))

    while q:
        px, py = q.pop()
        if visited[px][py]:
            continue

        visited[px][py] = True
        for i in range(4):
            nx, ny = px + dx[i], py + dy[i]
            if 0 <= nx < N and 0 <= ny < M and lab[nx][ny] == 0 and visited[nx][ny] is not True:
                q.append((nx,ny))
                lab[nx][ny] = 2

res = 0

for comb in walls_comb:
    new_lab = build_wall(comb)
    spread_virus(new_lab)
    count = 0
    for i in range(N):
        for j in range(M):
            if new_lab[i][j] == 0:
                count += 1

    res = max(res, count)

print(res)
