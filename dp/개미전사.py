def solution(n, food_list):
    d = [0]*n
    d[0] = food_list[0]
    d[1] = max(food_list[0], food_list[1])

    for i in range(2, n+1):
        d[i] = max(d[i-2]+food_list[i-1], d[i-1])

    print(d[n])


if __name__ == "__main__":
    n = int(input())
    food_list = list(map(int, input().split()))
    solution(n, food_list)