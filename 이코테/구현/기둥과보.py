n = int(input())
build_frame = [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]
nmap = [[-1] * (n + 1) for _ in range(n + 1)]
res = []

def buildable(cx, cy, ca):
    print(cx,cy,ca)
    if ca == 0:
        if cy == 0:
            return True
        if cx - 1 >= 0 and (nmap[cx-1][cy] == -1 or nmap[cx-1][cy] == 2):
            return True
        if cy - 1 >= 0 and (nmap[cx][cy-1] == 1 or nmap[cx][cy-1] == 2):
            return True
        return False
    else:
        if cx == 0:
            return True
        if cx - 1 >= 0 and nmap[cx-1][cy] == -1:
            return True
        if cx - 1 >= 0 and cy + 1 < n and nmap[cx-1][cy+1] == 1:
            return True
        if cy - 1 >= 0 and cy + 1 < n:
            if nmap[cx][cy-1] == 1 and nmap[cx][cy+1] == 1:
                return True
        return False

def removable(cx, cy, ca):
    if ca == 0:
        if cx + 1 >= n or nmap[cx+1][cy] == -1:
            return False
        if cx - 1 >= 0 and cy - 1 >= 0 and nmap[cx-1][cy-1] == 1:
            return True
        return False
    else:
        if cx - 1 >= 0 and nmap[cx][cy] == 0 and nmap[cx-1][cy] != -1:
            return True
        if cx - 1 >= 0 and cy + 1 >= 0 and nmap[cx-1][cy+1] == 0:
            return True
        return False

def find(cx, cy, ca):
    for i in range(len(res)):
        if res[i][0] == cx and res[i][1] == cy and res[i][2] == ca:
            return i

for i in range(len(build_frame)):
    ableResult = False
    x = int(build_frame[i][0])
    y = int(build_frame[i][1])
    a = int(build_frame[i][2])
    if int(build_frame[i][3]) == 1: # 설치인 경우
        ableResult = buildable(x,y,a)
        print('설치: ' + str(ableResult))
        if ableResult:
            res.append([x,y,a])

    else:
        ableResult = removable(int(build_frame[i][0]), int(build_frame[i][1]), int(build_frame[i][2]))
        print('삭제: ' + str(ableResult))
        if ableResult:
            idx = find(x,y,a)
            res.pop(idx)

res.sort(key=lambda x: (x[0], x[1], x[2]))
print(res)
            
    
