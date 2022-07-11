n = input()

l, r = 0, 0
half_size = len(n) // 2
for i in range(0, half_size):
    l += int(n[i])
    r += int(n[half_size+i])

if l == r:
    print('LUCKY')
else:
    print('READY')