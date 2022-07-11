from collections import deque

if __name__ == "__main__":
    n,m = map(int, input().split())
    miro = []
    visited = []

    for _ in range(n):
        miro.append(input())
        visited.append([False]*m)

    dx = [0,0,-1,1]
    dy = [-1,1,0,0]

    # 저장해야할 사항: 현재위치 및 움직인 횟수
    queue = deque()
    queue.append((0,0,1))
    visited[0][0] = True
    cnt = 0
    while queue:
        (x, y, cnt) = queue.popleft()
        if x == n-1 and y == m-1:
            print(cnt)
            break

        # 이동하기
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if visited[nx][ny] or miro[nx][ny] == 0:
                continue

            cnt += 1
            queue.append((nx,ny,cnt))
            visited[nx][ny] = True
