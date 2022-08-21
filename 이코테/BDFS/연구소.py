import sys
input = sys.stdin.readline
n, m = map(int, input().split())
lab_map = []
temp = [[0] * m for _ in range(n)]
res = 0
for _ in range(n):
    row = list(map(int, input().split()))
    lab_map.append(row)

def make_virus(px, py):
    dirs = [(1,0),(0,1),(-1,0),(0,-1)]
    for dir in dirs:
        nx, ny = px + dir[0], py + dir[1]
        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue
        if temp[nx][ny] == 0:
            temp[nx][ny] = 2
            make_virus(nx, ny)
        

def count_zero(lab_map:list):   
    cnt = 0
    for i in range(n):
        for j in range(m):
            if lab_map[i][j] == 0:
                cnt +=1
    return cnt

def make_wall(count):
    global res
    if count == 3:
        for i in range(n):
            for j in range(m):
                temp[i][j] = lab_map[i][j]
        # 바이러스 퍼지기
        for i in range(n):
            for j in range(m):
                if temp[i][j] == 2:
                    make_virus(i, j)
        # 안전 영역 계산
        cnt = count_zero(temp)
        res = max(res, cnt)
        return
    for i in range(n):
        for j in range(m):
            if lab_map[i][j] == 0:
                count += 1
                lab_map[i][j] = 1
                make_wall(count)
                lab_map[i][j] = 0
                count -= 1

make_wall(0)
print(res)