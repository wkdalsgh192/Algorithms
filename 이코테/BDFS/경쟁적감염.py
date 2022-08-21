import sys
import heapq

input = sys.stdin.readline
n, k = map(int, input().split())
data = []

for _ in range(n):
    data.append(list(map(int, input().split())))

s, x, y = map(int, input().split())

heap = []
for i in range(n):
    for j in range(n):
        if data[i][j] > 0:
            heapq.heappush(heap, (0, data[i][j], i, j))

dirs = [(1,0), (0,1), (-1,0), (0,-1)]
while len(heap) > 0:
    t, v, px, py = heapq.heappop(heap)
    # print(t,v,px,py)

    if t >= s:
        break

    for dir in dirs:
        nx, ny = px + dir[0], py + dir[1]

        if nx < 0 or nx >= n or ny < 0 or ny >= n or data[nx][ny] != 0:
            continue

        data[nx][ny] = v
        heapq.heappush(heap, (t+1, v, nx, ny))
    


print(data[x-1][y-1])