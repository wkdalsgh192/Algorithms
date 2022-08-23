def solution(n, weak, dist):
    W, F = len(weak), len(dist)
    repair_list = [()] # 현재까지 고칠 수 있는 취약점들 저장
    count = 0
    dist.sort(reverse = True)

    # 한 친구씩 나와서 비교하고, 갈 수 있는 조합을 모두 저장하기
    for can_move in dist:
        repairs = []
        count += 1

        # 수리 가능한 지점 찾기
        for i, wp in enumerate(weak):
            start = wp
            ends = weak[i:] + [n+w for w in weak[:i]] # 시작점 기준 끝 포인트 값 저장
            can = [end % n for end in ends if end - start <= can_move] # 반대 방향은 왜 고려하지 않지?
            repairs.append(set(can))

        # 수리 가능한 경우 탐색
        cand = set()
        for r in repairs:
            for x in repair_list:
                new = r | set(x)
                if len(new) == W:
                    return count
                cand.add(tuple(new))
                print(cand)

        repair_list = cand

    return -1

n = 12
# weak = [1, 5, 6, 10]	
weak = [1, 3, 4, 9, 10]
# dist = [1, 2, 3, 4]
dist = [3, 5, 7]

print(solution(n, weak, dist))
