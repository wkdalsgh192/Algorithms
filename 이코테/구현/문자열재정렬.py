def solution():
    data = input()
    result = []
    value = 0

    for x in data:
        if x.isalpha():
            result.append(x)

        else:
            value += int(x)

    result.sort()

    if value != 0:
        result.append(str(value))

    print(''.join(result))

def trial():
    s = input()
    ss = [0] * 100

    cnt = 0
    for i in range(len(s)):
        if ord(s[i]) > 57:
            idx = ord(s[i]) - 65
            ss[idx] += 1
        else:
            cnt += int(s[i])

    res = ''
    for i in range(len(ss)):
        while ss[i] > 0:
            res += chr(i+65)
            ss[i] -= 1
    else:
        res += str(cnt)

    print(res)