key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]

m = len(key)
n = len(lock)

new_lock = [[0] * (n * 3) for _ in range(n * 3)]
for i in range(n):
    for j in range(n):
        new_lock[i+n][j+n] = lock[i][j]

# 키 회전하기
def rotate_key(key, cnt):
    m = len(key)
    new_key = [[0]*m for _ in range(m)]
    for _ in range(cnt):
        new_key = [[0]*m for _ in range(m)]
        for i in range(m):
            for j in range(m):
                new_key[j][m-i-1] = key[i][j] 
        key = new_key

    return new_key

res = True
for i in range(3*n-m):
    for j in range(3*n-m):
        for k in range(4):
            # 회전
            target_key = rotate_key(key, k)

            # 맞는 지 확인하기
            # 시작점 - i, j
            for x in range(n):
                for y in range(n):
                    if i + x < n or i + x >= 2*n or j + y < n or j + y >= 2*n:
                        continue
                    elif new_lock[i+x][j+y] == 1 and target_key[x][y] == 0:
                        continue
                    elif new_lock[i+x][j+y] == 0 and target_key[x][y] == 1:
                        continue
                    else:
                        res = False
            
            if res == True:
                break
            else:
                res = False

        if res == True:
            break

if res == True:
    print("true")
else:
    print("false")

