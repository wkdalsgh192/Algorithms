from collections import deque
import sys
input = sys.stdin.readline
N, L, R = map(int, input().split())
data = []
for _ in range(N):
    data.append(list(map(int, input().split())))

q = deque([])

dirs = [(0, 1), (0, -1), (-1, 0), (1, 0)]

# (i, j)에 해당하는 연합 만들기
def make_union(i, j):
    elem_set = set()
    q.append((i, j))
    elem_set.add((i, j))
    while q:
        px, py = q.pop()

        for dir in dirs:
            nx, ny = px + dir[0], py + dir[1]
            if 0 <= nx < N and 0 <= ny < N and (nx, ny) not in elem_set and L <= abs(data[nx][ny] - data[px][py]) <= R:
                q.append((nx, ny))
                elem_set.add((nx, ny))
                visited[nx][ny] = True

    q.clear()
    return elem_set
                
cnt = 0
while True:
    # print(data)
    union_list = []
    visited = [[False] * N for _ in range(N)]    
    for i in range(N):
        for j in range(N):
            if visited[i][j] is False:
                union = make_union(i, j)
                if union and len(union) > 1:
                    union_list.append(union)

    if union_list:
        for union in union_list:
            total_population = 0
            total_cnt = 0
            for (i, j) in union:
                total_population += data[i][j]
                total_cnt += 1
            
            for (i, j) in union:
                data[i][j] = total_population // total_cnt
        cnt += 1
    else:
        print(cnt)
        break

