import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n, m, c = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    x, y, z = map(int, input().split())
    graph[x].append((y, z))
distance = [INF] * (n + 1)

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        # 현재까지 갱신된 now 노드로 오는 최단 경로보다 dist가 크면 갱신할 필요가 없음
        if distance[now] < dist:
            continue

        # 작으면 now 노드와 연결된 다른 노드로 가는 최단 경로 탐색
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(c)
cnt = 0
min_time = 0
for i in distance:
    if i > 0 and i < INF:
        cnt+=1
        min_time = max(min_time, i)

print(cnt, min_time)