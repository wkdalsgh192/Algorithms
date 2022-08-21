from collections import deque
def solution(p):

    def split(p):
        if len(p) == 0:
            return '', ''
        open_cnt = 0
        close_cnt = 0
        for i in range(len(p)):
            if open_cnt > 0 and open_cnt == close_cnt:
                return p[:i], p[i:]
            if p[i] == '(':
                open_cnt += 1
            else:
                close_cnt += 1
        return p[:len(p)], ''
            
    
    def check(u):
        if len(u) == 0:
            return True
        
        if u[0] == ')':
            return False
        return True
    
    def do(p):
        res = ''
        u, v = split(p)
        print(u, v)
        if check(u):
            if len(v) > 0:
                res += u + do(v)
            else:
                res += u
        else:
            res += '(' + do(v) + ')'
            if len(u) > 2:
                for ud in u[1:len(u)-1]:
                    if ud == '(':
                        res += ')'
                    else:
                        res += '('
        return res

    return do(p)

print(solution("()))((()"))