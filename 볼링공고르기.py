n,m = map(int, input().split())
dd = list(map(int, input().split()))

cnt_list = [0] * (m + 1)
for d in dd:
    cnt_list[d] += 1

res = n * (n-1) // 2
for cnt in cnt_list:
    if cnt >= 2:
        res -= cnt * (cnt-1) // 2

print(res)