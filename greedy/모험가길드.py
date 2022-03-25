def solution():
    target_list = list(map(int, input().split()))
    target_list.sort(reverse=True)

    answer = 0
    for i in range(len(target_list)):
        s = i
        cnt = 0
        length = len(target_list)
        while s < length:
            e = s + target_list[s] - 1
            if e >= length:
                break
            else:
                s = e + 1
                cnt += 1
        answer = max(answer, cnt)

    return answer

def answer():
    fears = [1, 2, 4, 2, 2, 1, 1, 3]
    fears.sort()
    count = 0
    result = 0

    for f in fears:
        count += 1
        if f == count:
            result += 1
            count = 0

    return result


if __name__ == "__main__":
    print(solution())

