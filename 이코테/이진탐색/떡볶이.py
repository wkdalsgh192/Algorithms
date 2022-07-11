import sys
input = sys.stdin.readline

res = 0
n , m = map(int, input().split())
dd = list(map(int, input().split()))

min = min(dd)
max = max(dd)

while min <= max:
    sum = 0
    h = (min + max) // 2
    for d in dd:
        if d > h:
            sum += d-h
    
    if sum >= m:
        res = h
        min = h + 1
    else:
        max = h - 1

print(res)