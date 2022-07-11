from collections import deque


def trial():
    n, m = map(int, input().split())
    ice_map = []
    visited = []
    for _ in range(n):
        ice_map.append(list(map(int, input())))
        visited.append([False] * m)

    cnt = 0
    dx = [-1, +1, 0, 0]
    dy = [0, 0, -1, +1]
    for i in range(n):
        for j in range(m):
            if not visited[i][j] and ice_map[i][j] == 0:
                # bfs 탐색 시작
                queue = deque([(i, j)])
                while queue:
                    x, y = queue.popleft()
                    if visited[x][y]:
                        continue
                    visited[x][y] = True
                    for k in range(4):
                        nx = x + dx[k]
                        ny = y + dy[k]
                        if nx < 0 or ny < 0 or nx >= n or ny >= m:
                            continue
                        if ice_map[nx][ny] == 0 and not visited[nx][ny]:
                            queue.append((nx, ny))

                cnt += 1

    print(cnt)

if __name__ == "__main__":
    trial()