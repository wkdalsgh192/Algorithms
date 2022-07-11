x = int(input())
d = [0] * 30001

for i in range(2, x+1):
    if i % 5 == 0:
        d[i] = min(d[i//5] + 1, d[i-1] + 1)
    elif i % 3 == 0:
        d[i] = min(d[i//3] + 1, d[i-1] + 1)
    elif i % 2 == 0:
        d[i] = min(d[i//2] + 1, d[i-1] + 1)
    else:
        d[i] = d[i-1] + 1
        
print(d[x])