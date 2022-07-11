if __name__ == "__main__":
    n, m = map(int, input().split())
    coins = list()
    for i in range(n):
        coins.append(int(input()))

    d = [9999]*10001
    for c in coins:
        d[c] = 1
    
    for i in range(1, m+1):
        for j in coins:
            if i <= j:
                continue
            else:
                d[i] = min(d[i], d[i-j]+1)

    if d[m] == 9999:
        print(-1)
    else:
        print(d[m])
