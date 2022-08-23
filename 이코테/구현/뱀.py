# 인풋을 받는다.
n = int(input())
k = int(input())

map = [[0] * (n + 1) for _ in range(n + 1)]
for _ in range(k):
    x, y = input().split(' ')
    map[int(x)][int(y)] = 1 # 사과의 위치 표시

l = int(input())
dir_changes = []
for _ in range(l):
    x, y = input().split(' ')
    dir_changes.append((x, y))

# 판과 방향을 세팅한다.
curdir = 0
curtime = 0
dirs = [(0,1),(1,0),(0,-1),(-1,0)]

# 뱀을 위치시킨다.
snake = []
snake.append((1,1))
hx, hy = 1, 1
map[hx][hy] = 2

# 사과가 남아있을 때까지한다
while True:
    print('current snake: ', snake)
    # 뱀이 이동할 좌표를 갱신한다.
    nx, ny = hx + dirs[curdir][0], hy + dirs[curdir][1]
    # 벽에 부딪히는 지 확인한다.
    if nx > n or nx < 1 or ny > n or ny < 1:
        print("벽에 부딪혔다.",nx,ny, curtime)
        curtime += 1
        break
    # 자기 자신에 부딪히는 지 확인한다
    if len(snake) == 0 or map[nx][ny] == 2:
        print("자기 자신에게 부딪혔다.",nx,ny, curtime)
        curtime += 1
        break
    # 사과가 있는 지 확인한다.
    elif map[nx][ny] == 1:
        print("사과 발견",nx,ny, curtime)
        snake.append((nx, ny))
        map[nx][ny] = 2 
    else:
        print("사과 없음",nx,ny, curtime)
        snake.append((nx, ny))
        map[nx][ny] = 2
        mx, my = snake.pop(0)
        map[mx][my] = 0

    hx, hy = nx, ny
    curtime += 1

    # 현재 시간이 방향 변환 정보에 있는 지 확인
    if len(dir_changes) > 0:
        time, nd = dir_changes[0]
        if curtime == int(time):
            print(curtime, time)
            if nd == "D":
                curdir = (curdir + 1) % 4
            else:
                curdir = (curdir - 1) % 4
            dir_changes.pop(0)
            print(curdir)

    

print(curtime)