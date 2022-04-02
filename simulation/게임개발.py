def solution():
    n,m = map(int, input().split())
    x,y,d = map(int, input().split())

    game_map = []
    for i in range(n):
        game_map.append(list(map(int, input().split())))
    
    dir_list = [(-1,0),(0,+1),(+1,0),(0,-1)]

    cnt = 0
    while True:
        print(x,y,d)
        nd=nx=ny=0
        # 방향 정하기
        nd = d - 1
        if nd == -1:
            nd = 3
        flag = False
        for j in range(len(dir_list)-1,-1):
            if nd == j:
                nx = x + dir_list[nd][0]
                ny = y + dir_list[nd][1]
            if game_map[nx][ny] == 1 or game_map[nx][ny] == -1:
                d = nd
                continue
            d = nd
            x = nx
            y = ny
            game_map[x][y] = -1
            cnt += 1
            flag = True
            break
        if flag == False:
            if d <= 1:
                d += 2
            else:
                d -= 2
        nx = x + dir_list[d][0]
        ny = y + dir_list[d][1]

        if game_map[nx][ny] == 1:
            return cnt
        else:
            x = nx
            y = ny
            cnt += 1
            print("for real?")

        for elem in game_map:
            print(elem)
    
    return cnt


if __name__ == "__main__":
    print(solution())