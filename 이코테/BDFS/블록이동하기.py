from collections import deque

def solution(board):
    n = len(board)
    q = deque()
    visited = set()
    
    dirs = [(1,0), (-1,0), (0,1), (0,-1)]
    rotates = [(1,-1),(1,1),(-1,-1),(-1,1)]

    q.append((0,0,0,1, 0))


    def rotate(x1,y1,x2,y2,chuck_num, clockwise):
        print("회전 시작: ", x1,y1,x2,y2)
        if clockwise:
            if chuck_num == 1:
                cx, cy = x1 + 1, y1 + 1
            
                if cx < 0 or cy < 0 or cx >= n or cy >= n or board[cx][cy] == 1:
                    return x1, y1, x2, y2, False
                
                nx, ny = x2 + 1, y2 - 1
                if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 0:
                    return x1, y1, nx, ny, True

            else:
                cx, cy = x2 - 1, y2 - 1
            
                if cx < 0 or cy < 0 or cx >= n or cy >= n or board[cx][cy] == 1:
                    return x1, y1, x2, y2, False
                
                nx, ny = x1 - 1, y1 + 1
                if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 0:
                    return nx, ny, x2, y2, True
        else:
            if chuck_num == 1:
                cx, cy = x1 - 1, y1 + 1
            
                if cx < 0 or cy < 0 or cx >= n or cy >= n or board[cx][cy] == 1:
                    return x1, y1, x2, y2, False
                
                nx, ny = x2 - 1, y2 - 1
                if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 0:
                    return x1, y1, nx, ny, True

            else:
                cx, cy = x2 + 1, y2 - 1
            
                if cx < 0 or cy < 0 or cx >= n or cy >= n or board[cx][cy] == 1:
                    return x1, y1, x2, y2, False
                
                nx, ny = x1 + 1, y1 + 1
                if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 0:
                    return nx, ny, x2, y2,True

        return x1,y1,x2,y2,False




    
    while q:
        x1,y1,x2,y2, t = q.pop()
        print(x1,y1,x2,y2,t)

        if (x1,y1) == (n-1, n-1) or (x2, y2) == (n-1, n-1):
            return t
        
        if (x1,y1,x2,y2) in visited:
            continue

        visited.add((x1,y1,x2,y2))

        # 로봇이 이동하는 경우
        for dir in dirs:
            nx1, ny1, nx2, ny2 = x1 + dir[0], y1 + dir[1], x2 + dir[0], y2 + dir[1]
            
            if 0 <= nx1 < n and 0 <= ny1 < n and 0 <= nx2 < n and 0 <= ny2 < n:

                if board[nx1][ny1] == 1 or board[nx2][ny2] == 1:
                    continue
                
                if (nx1, ny1, nx2, ny2) in visited:
                    continue
                
                # print("이동: ", nx1, ny1, nx2, ny2, "인덱스: ", dir)
                q.append((nx1, ny1, nx2, ny2, t + 1))

        # 로봇이 회전하는 경우
        for chuck_num in [1,2]:
            for clockwise in [True, False]:
                nx1,ny1,nx2,ny2,changed = rotate(x1,y1,x2,y2,1,True)
                if changed and (nx1,ny1,nx2,ny2) not in visited:
                    print("회전: ", nx1, ny1, nx2, ny2, changed, "인덱스: ", chuck_num, clockwise)
                    q.append((nx1, ny1, nx2, ny2, t + 1))
                
                
                # q.append((nx1, ny1, nx2, ny2, t + 1))


board = [[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]	
print(solution(board))
