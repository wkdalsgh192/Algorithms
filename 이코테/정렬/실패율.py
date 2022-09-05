def solution(N, stages):
    stages.sort()
    stage_list = [(i,0) for i in range(1, N+2)]
    curr_total = 0
    total = len(stages)
    cnt = 0
    value = 0
    for stage in stages:
        if value is not stage:
            if value  > 0:
                print(value, cnt, curr_total, cnt / (total-curr_total))
                print(stage_list[value])
                stage_list[value][1] = cnt / (total-curr_total)
            
            curr_total += cnt
            cnt = 1 
            value = stage

    stage_list.sort(key=lambda x: x[1])
    print(stage_list)
    answer = []
    return answer


N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
solution(N, stages)