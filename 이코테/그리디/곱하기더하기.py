n = input()

res = 0
for i in range(len(n)):
    ni = int(n[i])
    res = max(res+ni, res*ni)

print(res)

