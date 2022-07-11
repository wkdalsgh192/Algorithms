n = input()

zero, one = 0, 0
start = int(n[0])
for i in range(len(n)):
    if start != int(n[i]):
        if start == 0:
            zero += 1
        else:
            one += 1
    start = int(n[i])
else:
    if start == 0:
        zero += 1
    else:
        one += 1

print(min(zero,one))