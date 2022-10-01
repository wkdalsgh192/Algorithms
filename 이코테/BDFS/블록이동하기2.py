from collections import deque
from turtle import pos
def solution(board):
    N = len(board)
    dirs = [(1,0), (-1,0), (0,-1), (0,1)]
    q = deque([])
    q.append((0,0,0,1,0)) # 좌표 2개 및 시간
    position_set = set()
    position_set.add((0,0,0,1))

    while True:
        x1,y1,x2,y2,t = q.pop()
        print(x1,y1,x2,y2,t)
        if (x1, y1) == (N-1, N-1) or (x2, y2) == (N-1, N-1):
            return t

        # 4방향 이동
        for dir in dirs:
            nx1, nx2 = x1 + dir[0], x2 + dir[0]
            ny1, ny2 = y1 + dir[1], y2 + dir[1]

            if 0<= nx1 < N and 0<= nx2 < N and 0<= ny1 < N and 0<= ny2 < N:
                if board[nx1][ny1] == 0 and board[nx2][ny2] == 0 and (nx1,ny1,nx2,ny2) not in position_set:
                    q.append((nx1,ny1,nx2,ny2, t+1))
                    position_set.add((nx1,ny1,nx2,ny2))

        # 가로인 경우 회전 이동
        if x1 == x2:
            # 아래쪽 체크
            if 0 <= x1 + 1 < N and board[x1 + 1][y1] == 0 and board[x2 + 1][y2] == 0:
                # 왼쪽이 축이 되는 경우
                nx1,ny1,nx2,ny2 = x1, y1, x2 + 1, y1
                if (nx1,ny1,nx2,ny2) not in position_set:
                    q.append((nx1,ny1,nx2,ny2, t + 1))
                    position_set.add((nx1,ny1,nx2,ny2))

                # 오른쪽이 축이 되는 경우
                nx1,ny1,nx2,ny2 = x1 + 1, y2, x2, y2
                if (nx1,ny1,nx2,ny2) not in position_set:
                    q.append((nx1,ny1,nx2,ny2, t + 1))
                    position_set.add((nx1,ny1,nx2,ny2))
            
            # 위 체크
            if 0 <= x1 - 1 < N and board[x1 - 1][y1] == 0 and board[x2 - 1][y2] == 0:
                # 왼쪽이 축이 되는 경우
                nx1,ny1,nx2,ny2 = x1, y1, x2 - 1, y1
                if (nx1,ny1,nx2,ny2) not in position_set:
                    q.append((x1, y1, x2 - 1, y1, t + 1))
                    position_set.add((nx1,ny1,nx2,ny2))
                # 오른쪽이 축이 되는 경우
                nx1,ny1,nx2,ny2 = x1 - 1, y2, x2, y2
                if (nx1,ny1,nx2,ny2) not in position_set:
                    q.append((nx1,ny1,nx2,ny2, t + 1))
                    position_set.add((nx1,ny1,nx2,ny2))

        # 세로인 경우 회전 이동
        if y1 == y2:
            # 오른쪽 체크
            if 0 <= y1 + 1 < N and board[x1][y1 + 1] == 0 and board[x2][y2 + 1] == 0:
                # 위쪽이 축이 되는 경우
                nx1,ny1,nx2,ny2 = x1, y1, x1, y2 + 1
                if (nx1,ny1,nx2,ny2) not in position_set:
                    q.append((nx1,ny1,nx2,ny2, t + 1))
                    position_set.add((nx1,ny1,nx2,ny2))

                # 아래쪽이 축이 되는 경우
                nx1,ny1,nx2,ny2 = x2, y1 + 1, x2, y2
                if (nx1,ny1,nx2,ny2) not in position_set:
                    q.append((nx1,ny1,nx2,ny2, t + 1))
                    position_set.add((nx1,ny1,nx2,ny2))


            # 왼쪽 체크
            if 0 <= y1 - 1 < N and board[x1][y1 - 1] == 0 and board[x2][y2 - 1] == 0:
                # 위쪽이 축이 되는 경우
                nx1,ny1,nx2,ny2 = x1, y1, x1, y2 - 1
                if (nx1,ny1,nx2,ny2) not in position_set:
                    q.append((nx1,ny1,nx2,ny2, t + 1))
                    position_set.add((nx1,ny1,nx2,ny2))

                # 아래쪽이 축이 되는 경우
                nx1,ny1,nx2,ny2 = x2, y1 - 1, x2, y2
                if (nx1,ny1,nx2,ny2) not in position_set:
                    q.append((nx1,ny1,nx2,ny2, t + 1))
                    position_set.add((nx1,ny1,nx2,ny2))


board = [[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]
print(solution(board))