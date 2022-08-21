n = int(input())
dd = list(map(int, input().split()))

k = sum(dd)
res = k + 1
dd.sort()
if dd[0] > 1:
    print(1)
else:
    for i in range(k, 0, -1):
        for d in dd:
            if i == 0:
                break
            if i < d:
                continue
            i -= d
        if i > 0:
            res = i

def solution():
    n = int(input())
    dd = list(map(int, input().split()))
    dd.sort()

    target = 1
    for x in dd:
        if target < x:
            break
        target += x

    print(target)