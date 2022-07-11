import sys
input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append((b, 1))
    graph[b].append((a, 1))
x, k = map(int, input().split())

def dijkstra(start, distance):
    visited = [False] * (n + 1)

    # start -> start 의 거리는 0
    distance[start] = 0
    visited[start] = True

    for j in graph[start]:
        distance[j[0]] = j[1]

    for now in range(1, n + 1):
        if now == start:
            continue
        visited[now] = True

        for i in graph[now]:
            cost = distance[now] + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost

res = 0
distance = [INF] * (n + 1)
dijkstra(1, distance)
res += distance[k]
distance = [INF] * (n + 1)
dijkstra(k, distance)
res += distance[x]

if res > INF:
    print(-1)
else:
    print(res)
