def solution(key, lock):
    n  = len(lock)
    m = len(key)

    new_lock = [[0] * (3 * n) for _ in range(3 * n)]
    for i in range(n):
        for j in range(n):
            new_lock[i+n][j+n] = lock[i][j]

    def rotate(key):
        new_key = [[0] * m for _ in range(m)]
        for i in range(m):
            for j in range(m):
                new_key[i][j] = key[m-j-1][i]
        return new_key

    def match(new_lock):
        for i in range(n, 2*n):
            for j in range(n, 2 * n):
                if new_lock[i][j] != 1: # 이 부분에서 문제가 있어서 결국 통과 못함. 
                    return False
        return True

    for x in range(2 * n):
        for y in range(2 * n):
            for _ in range(4):
                key = rotate(key)
                for i in range(m):
                    for j in range(m):
                        new_lock[x + i][y + j] += key[i][j] # 돌기가 맞으면 전부 1이 된다.
                if match(new_lock): # 전부 1인지만 체크하면 된다.
                    return True
                for i in range(m):
                    for j in range(m):
                        new_lock[x + i][y + j] -= key[i][j]

    return False