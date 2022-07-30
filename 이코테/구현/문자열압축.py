def trial():

    s = input()

    unit = 1
    ans = int(1e9)
    while unit <= len(s) // 2:
        # setup
        i = 0
        res = ''
        cnt = 0
        current = s[:unit]
        # compute
        while i < len(s):
            print(i, unit)
            if s[i:i+unit] == current:
                    cnt += 1
                    i += unit
            else:
                if cnt == 1:
                    res += current
                else:
                    res += str(cnt) + current
                current = s[i:i+unit]
                i += unit
                cnt = 1
                
        else:
            if cnt == 1:
                    res += current
            else:
                res += str(cnt) + current

        # compare
        print(res)
        ans = min(ans, len(res))
        unit += 1

def solution(s):
    answer = len(s)

    for step in range(1, len(s) // 2 + 1):
        compressed = ""
        prev = s[0:step]
        count = 1

        for j in range(step, len(s), step):
            if prev == s[j:j + step]:
                count += 1
            else:
                compressed += str(count) + prev if count >= 2 else prev
                prev = s[j:j + step]
                count = 1
    compressed += str(count) + prev if count >= 2 else prev
    answer = min(answer, len(compressed))