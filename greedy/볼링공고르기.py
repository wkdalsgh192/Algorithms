def solution():
    N, M = map(int, input().split())
    numbers = list(map(int, input().split()))

    result = N*(N-1)//2
    array = [0]*11

    for x in numbers:
        array[x] += 1

    for i in range(1, M+1):
        if array[i] >= 2:
            result -= array[i]*(array[i]-1)//2
    
    print(result)


def solution2():
    n, m = map(int, input().split())
    data = list(map(int, input().split()))

    array = [0]*11
    for x in data:
        array[x]+=1

    result = 0
    for i in range(1, m+1):
        n -= array[i] # 무게가 i인 볼링공의 갯수(A가 선택)를 제외한 나머지
        result += array[i] * n # A가 선택 가능한 경우의 수 * B가 가능한 경우

    print(result)

if __name__ == "__main__":
    solution()