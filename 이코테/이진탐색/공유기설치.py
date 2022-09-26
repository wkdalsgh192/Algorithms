import sys
input = sys.stdin.readline

N, C = map(int, input().split())
data = []
for _ in range(N):
    data.append(int(input()))

# 오름차순 정렬 후 기준 파라미터 구하기
data.sort()
# 가능한 최소 간극
l = 1
# 가능한 최대 간극
r = data[N - 1] - data[0]
max_distance = 0

while l <= r:
    mid = (l + r) // 2
    
    pre, cur, cnt = 0, 1, 1
    while cur < N:
        if data[cur] - data[pre] >= mid:
            pre = cur
            cnt += 1
        cur += 1

    if cnt >= C:
        max_distance = max(max_distance, mid)
        l = mid + 1
    else:
        r = mid - 1

print(max_distance)



