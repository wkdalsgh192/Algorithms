from collections import deque
import sys
input = sys.stdin.readline
N,M,K,X = map(int, input().split())

cities = [[] for _ in range(N+1)]
for _ in range(M):
    A, B = map(int, input().split())
    cities[A].append(B)

distances = [K+1] * (N + 1)
q = deque()
q.append((X, 0))
while q:
    destination, distance = q.pop()
    if distances[destination] > distance:
        distances[destination] = distance
        for city in cities[destination]:
            q.append((city, distance + 1))

cnt = 0
for idx in range(1, N+1):
    if distances[idx] == K:
        print(idx)
        cnt += 1
else:
    if cnt == 0:
        print(-1)

