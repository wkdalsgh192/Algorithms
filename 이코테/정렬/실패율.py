def solution(N, stages):

    # 실패율 리스트 만들기
    failures = [0] * (N + 2)

    # 오름차순 정렬하기
    stages.sort()

    ## count 하는 부분에서 나는 틀림
    s_len = len(stages)
    for stage in set(stages):
        cnt = stages.count(stage)
        failures[stage] = cnt / s_len
        s_len -= cnt

    # 튜플로 묶기
    failure_set = []
    for i in range(1, N + 1):
        print(i, failures[i])
        failure_set.append((i, failures[i]))

    failure_set.sort(key=lambda x: (-x[1], x[0]))
    answer = []
    for f in failure_set:
        print(f)
        answer.append(f[0])
    return answer


N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
print(solution(N, stages))