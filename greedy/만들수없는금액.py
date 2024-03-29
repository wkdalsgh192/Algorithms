def solution():
    N = int(input())
    number_list = list(map(int, input().split()))
    number_list.sort()

    if number_list[0] > 1:
        return 1

    number_set = set()

    for i in range(N):
        sum = 0
        for j in range(i, N):
            sum += number_list[j]
            number_set.add(sum)

    answer = 1
    while answer in number_set:
        answer += 1

    return answer

def solution2():
    n = int(input())
    data = list(map(int, input().split()))
    data.sort()

    target = 1
    for x in data:
        if target < x:
            return target
        target += x
    
    print(target)


if __name__ == "__main__":
    print(solution())