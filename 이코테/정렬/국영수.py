import sys
input = sys.stdin.readline
n = int(input())
sort_list = []
for _ in range(n):
    name, korean, english, math = input().split()
    sort_list.append(tuple([name, int(korean), int(english), int(math)]))

sort_list.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))
for sort in sort_list:
    print(sort[0])