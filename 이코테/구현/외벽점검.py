
def solution(n, weak, dist):
    dist.sort(reverse=True)
    idx = 0
    visited = [True] * n
    for w in weak:
        visited[w] = False

    while idx < len(dist):
        if sum(visited) == n:
            break
        # 각 출발 지점에서 출발했을 때, 어느 지점에서 출발하는 게 가장 좋은가?
        s_idx, max_cnt, cw = 0, 0, True
        for i in range(n):
            # 시계방향으로 출발하는 경우
            cnt = 0
            for pos in range(i, i+dist[idx]+1):
                if pos >= n:
                    pos -= n
                if pos in weak and visited[pos] is False:
                    cnt += 1
            if cnt >= max_cnt:
                s_idx, max_cnt, cw = i, cnt, True
                
            # 반시계방향으로 출발하는 경우
            cnt = 0
            for pos in range(i,i-dist[idx]-1):
                if pos in weak and visited[pos] is False:
                    cnt += 1
            if cnt >= max_cnt:
                s_idx, max_cnt, cw = i, cnt, False

        print(s_idx, max_cnt, cw)
        
        if cw:
            for pos in range(s_idx, i+dist[idx]+1):
                if pos >= n:
                    pos -= n
                if pos in weak and visited[pos] is False:
                    visited[pos] = True
        else:
            for pos in range(s_idx, i-dist[idx]-1):
                if pos in weak and visited[pos] is False:
                    visited[pos] = True
            
        idx += 1

    if sum(visited) == n:
        return idx
    else:
        return -1

n = 12
weak = [1, 5, 6, 10]	
dist = [1, 2, 3, 4]

print(solution(n, weak, dist))