# 이코테 그리디 유형별 실전문제 2번

def solution():
    S = input()
    result = int(S[0])
    for i in range(1, len(S)):
        s = int(S[i])
        result = max(result + s, result * s)
    return result


if __name__ == "__main__":
    print(solution())
