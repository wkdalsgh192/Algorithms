import heapq
import sys
input = sys.stdin.readline
N = int(input())
cards = []

for _ in range(N):
    heapq.heappush(cards, int(input()))

res = 0
while len(cards) > 1:
    one = heapq.heappop(cards)
    two = heapq.heappop(cards)
    res += one + two
    heapq.heappush(cards, one+two)

print(res)
