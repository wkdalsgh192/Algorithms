from collections import deque
n, m = map(int, input().split())
lab = []
for _ in range(n):
    lab.append(list(map(int, input().split())))

dir_x = [1,0,-1,0]
dir_y = [0,1,0,-1]

def spread(lab:list):
    new_lab = lab.copy()
    q = deque([])
    for i in range(n):
        for j in range(m):
            if new_lab == 2:
                q.append((i,j))

    while q:
        x, y = q.pop()
        for idx in range(4):
            nx, ny = x + dir_x[idx], y + dir_y[idx]

            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            if new_lab[nx][ny] != 0:
                continue

            new_lab[nx][ny] = 2
            q.append((nx,ny))
    
    return new_lab
            
def count(lab):
    cnt = 0
    for i in range(n):
        for j in range(m):
            if lab[i][j] == 0:
                cnt += 1

    return cnt

res = 0
for i1 in range(n):
    for j1 in range(m):
        if lab[i1][j1] != 0:
            continue
        for i2 in range(n):
            for j2 in range(m):
                if lab[i2][j2] != 0:
                    continue
                for i3 in range(n):
                    for j3 in range(m):
                        # make three walls
                        if lab[i3][j3] != 0:
                            continue
                        lab[i1][j1] = 1
                        lab[i2][j2] = 1
                        lab[i3][j3] = 1

                        new_lab = spread(lab)
                        res = max(res, count(new_lab))

                        lab[i1][j1] = 0
                        lab[i2][j2] = 0
                        lab[i3][j3] = 0
                        # virus spread out
                        # check safe area

print(res)