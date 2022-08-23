n = int(input())
num_apple = int(input())
apples = []

for _ in range(num_apple):
    x, y = map(int, input().split())
    apples.append([x, y])

num_dir = int(input())
dirs = []
for _ in range(num_dir):
    x, y = input().split()
    dirs.append([int(x), y])

def change_direction(cur_dir, dir_to_change):
    print(cur_dir, dir_to_change)
    if dir_to_change == 'D':
        cur_dir = (cur_dir+1) % 4
    else:
        cur_dir = (cur_dir-1) %4
    return cur_dir

hx, hy = 1, 1
snakes = []
snakes.append([hx, hy])

x_dir = [0,1,0,-1]
y_dir = [1,0,-1,0]

time = 0
cur_dir = 0
while True:
    print("current head: ", hx, hy)
    print("current snake: ", snakes)

    # 방향 정보 갱신
    if len(dirs) > 0 and time == dirs[0][0]:
        cur_dir = change_direction(cur_dir, dirs[0][1])
        print(time, dirs[0], cur_dir, hx, hy)
        dirs.pop(0)

    # 움직일 헤드 좌표 구하기
    nx, ny = hx+x_dir[cur_dir], hy+y_dir[cur_dir]
    if nx < 1 or nx > n or ny < 1 or ny > n or [nx,ny] in snakes:
        time += 1
        # return time
        print(time)
        break
    # 문제가 없으면 움직인다
    if [nx, ny] in apples:
        apples.remove([nx, ny])
        snakes.append([nx, ny])
    else:
        snakes.pop(0)
        snakes.append([nx,ny])

    # 헤드 및 시간 정보 갱신
    hx, hy = nx, ny
    time += 1
        

    