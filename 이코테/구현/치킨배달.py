from itertools import combinations, permutations
n, m = map(int, input().split())

city = []
for _ in range(n):
    city.append(list(map(int, input().split())))

chicken_list = []
for i in range(n):
    for j in range(n):
        if city[i][j] == 2:
            chicken_list.append((i, j))


# 유지하는 치킨 집 리스트가 주어졌을 떄, 도시의 치킨 거리를 구하는 함수
def get_distance(alt_list):
    total_distance = 0
    for x in range(n):
        for y in range(n):
            if city[x][y] == 1:
                distance = int(1e9)
                for chicken in alt_list:
                    pos = chicken[0]
                    distance = min(distance, abs(x-pos[0]) + abs(y-pos[1]))
                total_distance += distance
    print(total_distance, alt_list)
    return total_distance

# 겹치지 않게 치킨 집을 1이상 M 이하 고르기
# 단 치킨 거리가 최소가 되어야 함
def select(num):
    return list(combinations(chicken_list, num))

res = int(1e9)
alt_list = select(m)
# 후보 치킨 집 고르기
for alt in alt_list:
    total_distance = 0
    # 각 집마다 치킨 거리 고르기
    for x in range(n):
        for y in range(n):
            distance = 999
            if city[x][y] == 1:
                for i in range(m):
                    distance = min(distance, abs(x-alt[i][0])+abs(y-alt[i][1]))
                total_distance += distance
    res = min(res, total_distance)


print(res)