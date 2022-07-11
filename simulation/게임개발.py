def trial():
    n, m = map(int, input().split())
    x, y, d = map(int, input().split())

    game_map = []
    for i in range(n):
        game_map.append(list(map(int, input().split())))

    dir_list = [(-1, 0), (0, +1), (+1, 0), (0, -1)]

    cnt = 1
    while True:
        nd = d - 1  # 새로운 방향
        nx = ny = 0  # 새로운 좌표
        flag = False  # 탐색 결과 플래그

        while d != abs(nd):
            if nd < 0:
                nd = 3
            if game_map[x + dir_list[nd][0]][y + dir_list[nd][1]] == 0:
                flag = True
                break
            nd -= 1

        if flag:
            nx = x + dir_list[nd][0]
            ny = y + dir_list[nd][1]
            game_map[nx][ny] = -1
            cnt += 1
            # 현재 값 갱신
            x, y, d = nx, ny, d
        else:
            # 뒤가 바다인지 탐색
            if d < 2:
                nd = d + 2
            else:
                nd = d - 2
            if game_map[x + dir_list[nd][0]][y + dir_list[nd][1]] == 1:
                return cnt
            else:
                nx = x + dir_list[nd][0]
                ny = y + dir_list[nd][1]
                cnt += 1
                # 현재 값 생신
                x, y, d = nx, ny, d

    return cnt


global direction


def solution():
    n, m = map(int, input().split())
    d = [[0] * m for _ in range(n)]
    x, y, direction = map(int, input().split())
    d[x][y] = 1  # 현재 좌표 방문 처리

    array = []
    for i in range(n):
        array.append(list(map(int, input().split())))

    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    count = 1
    turn_time = 0

    def turn_left():
        global direction
        direction -= 1
        if direction == -1:
            direction = 3

    while True:
        turn_left()
        nx = x + dx[direction]
        ny = y + dy[direction]

        if d[nx][ny] == 0 and array[nx][ny] == 0:
            d[nx][ny] = 1
            x = nx
            y = ny
            count += 1
            turn_time = 0
            continue
        else:
            turn_time += 1

        if turn_time == 4:
            nx = x - dx[direction]
            ny = y - dy[direction]
            if array[nx][ny] == 0:
                x = nx
                y = ny
            else:
                break
            turn_time = 0


if __name__ == "__main__":
    print(solution())
