from collections import deque

def get_next_pos(pos, board):
    next_pos = [] # 반환 결과로 이동가능한 위치들
    pos = list(pos) # 현재 위치 정보를 리스트로 변환
    px1, py1, px2, py2 = pos[0][0], pos[0][1], pos[1][0], pos[1][1]

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    for i in range(4):
        nx1, ny1, nx2, ny2 = px1 + dx[i], py1 + dy[i], px2 + dx[i], py2 + dy[i]

        if board[nx1][ny1] == 0 and board[nx2][ny2] == 0:
            next_pos.append({(nx1,ny1), (nx2, ny2)})

    # 로봇이 가로로 놓여있는 경우
    if px1 == px2:
        # 위쪽 또는 아래쪽으로 회전
        for i in [-1,1]:
            # 위쪽 또는 아래쪽 두 칸이 모두 비어있다면
            if board[px1 + i][py1] == 0 and board[px2 + i][py2] == 0:
                next_pos.append({(px1, py1), (px1 + i, py1)})
                next_pos.append({(px2, py2), (px2 + i, py2)})

    elif py1 == py2:
        for i in [-1,1]:
            # 왼쪽 또는 오른쪽 두 칸이 모두 비어있다면
            if board[px1][py1 + i] == 0 and board[px2][py2 + i] == 0:
                next_pos.append({(px1,py1), (px1, py1 + i)})
                next_pos.append({(px2,py2), (px2, py2 + i)})

    return next_pos

def solution(board):
    n = len(board)

    new_board = [[1]* (n + 2) for _ in range(n + 2)]
    for i in range(n):
        for j in range(n):
            new_board[i + 1][j + 1] = board[i][j]

    q = deque()
    visited = []
    pos = {(1,1), (1,2)}
    q.append((pos, 0))
    visited.append(pos)
    while q:
        pos, cost = q.popleft()
        if (n,n) in pos:
            return cost
        for next_pos in get_next_pos(pos, new_board):
            if next_pos not in visited:
                q.append((next_pos, cost + 1))
                visited.append(next_pos)

    return 0


board = [[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]	
print(solution(board))