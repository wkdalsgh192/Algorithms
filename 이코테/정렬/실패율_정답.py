def solution(N, stages):
    answer = []
    length = len(stages)

    for number in range(1, N + 1):
        count = stages.count(number)

        if length == 0:
            fail = 0
        else:
            fail = count / length

        answer.append((number, fail))
        length -= count

    answer.sort(key = lambda x: -x[1])
    answer = [number[0] for number in answer ]
    return answer