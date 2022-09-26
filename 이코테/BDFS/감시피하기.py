import sys
from itertools import combinations
input = sys.stdin.readline
N = int(input())
data = []

for _ in range(N):
    data.append(list(input().split()))

empty_list = []
for i in range(N):
    for j in range(N):
        if data[i][j] == 'X':
            empty_list.append((i, j))
        
wall_list = combinations(empty_list, 3)

def copy(data):
    copy = [[i] * N for i in range(N)]
    for i in range(N):
        for j in range(N):
            copy[i][j] = data[i][j]
    return copy

# 한 선생님이 감시할 때의 메소드
def spectate(px, py, idx, data):
    dirs = [(0,1), (1,0), (0, -1), (-1,0)]
    while 0 <= px < N and 0 <= py < N:
        if data[px][py] == 'O':
            return
        if data[px][py] == 'S':
            # 걸리면 리턴
            return False
        
        px += dirs[idx][0]
        py += dirs[idx][1]
    return True


# 벽 세우기
res = 'NO'
for walls in wall_list:
    new_data = copy(data)
    for wall in walls:
        x, y = wall
        new_data[x][y] = 'O'

    # 감시하기
    cnt = 0
    for i in range(N):
        for j in range(N):
            if new_data[i][j] == 'T':
                for idx in range(4):
                    # 한 명이라도 걸렸다면
                    if spectate(i, j, idx, new_data) is False:
                        cnt += 1
    
    if cnt == 0:
        res = 'YES'
        break

print(res)
    
                


    

    