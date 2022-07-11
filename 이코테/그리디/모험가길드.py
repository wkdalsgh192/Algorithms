def trial():
    n = int(input())
    d = list(map(int, input().split()))
    k = [0] * (max(d) + 1)
    res = 0

    for i in d:
        k[i] += 1

    for i in range(1, len(k)):
        res += k[i] // i
        k[i] %= i 

    cnt = 0
    for i in range(1, len(k)):
        if k[i] > 0:
            cnt += k[i]
            if cnt >= i:
                res += 1
                cnt -= i

    print(res)
