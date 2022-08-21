import sys
input = sys.stdin.readline
n = int(input())
data = list(map(int, input().split()))
op1, op2, op3, op4 = map(int, input().split())

max_num = int(1e9)*-1
min_num = int(1e9)
def calc(ans, i):
    global op1, op2, op3, op4, max_num, min_num
    if i == n:
        max_num = max(max_num, ans)
        min_num = min(min_num, ans)
        return
    
    if op1 > 0:
        op1 -= 1
        calc(ans + data[i], i + 1)
        op1 += 1
    if op2 > 0:
        op2 -= 1
        calc(ans - data[i], i + 1)
        op2 += 1
    if op3 > 0:
        op3 -= 1
        calc(ans * data[i], i + 1)
        op3 += 1
    if op4 > 0:
        # 음수를 양수로 나눌 때에는, 양수로 바꾼 뒤 몫을 취하고, 몫을 음수로 바꾼다.
        op4 -= 1
        if ans < 0:
            calc((abs(ans) // data[i]) * -1, i + 1)
        else:
            calc(ans // data[i], i + 1)
        op4 += 1

ans = data[0]
calc(ans, 1)
print(max_num)
print(min_num)