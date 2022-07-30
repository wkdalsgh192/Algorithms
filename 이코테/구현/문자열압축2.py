s = input()
min_len = int(1e9)

#aab

for unit in range(1, len(s)//2 + 1):
    cnt = 1
    word_list = []
    for i in range(unit,len(s),unit):
        if s[i-unit:i] == s[i:i+unit]:
            cnt+=1
        else:
            if cnt == 1:
                word_list.append(s[i-unit:i])
            else:
                word_list.append(str(cnt)+s[i-unit:i])
            cnt = 1
    else:
        if cnt == 1:
                word_list.append(s[i:i+unit])
        else:
            word_list.append(str(cnt)+s[i:i+unit])
        cnt = 1

    res = ''
    for word in word_list:
        res += word
    print(res)
    min_len = min(min_len, len(res))

print(min_len)
