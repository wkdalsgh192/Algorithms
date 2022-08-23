from collections import deque

n, m, k, x = map(int, input().split())
roads = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    roads[a].append(b)

res = []
q = deque([x])

distance_list = [-1] * (n + 1)
distance_list[x] = 0
while q:
    now = q.popleft()

    for road in roads[now]:
        if distance_list[road] == -1:
            distance_list[road] = distance_list[now] + 1
            q.append(road)

check = False
for i in range(1, n + 1):
    if distance_list[i] == k:
        print(i)
        check = True

if check == False:
    print(-1)