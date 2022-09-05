import sys
input = sys.stdin.readline
n = int(input())
houses = list(map(int, input().split()))

houses.sort()
distance_sum = sum(houses) 
house_length = len(houses)

res = distance_sum // house_length

ans = 0
for house in houses:
    if res < house:
        break
    ans = house

print(ans)