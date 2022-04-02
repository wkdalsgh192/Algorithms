def solution():
    K = input()
    X = ' abcdefgh'
    result = 0    

    x = 0
    for i in range(len(X)):
        if K[0] == X[i]:
            x = i
    y = int(K[1])

    if 3<=x<=6 and 3<=y<=6:
        result = 8
        return result

    dx = [-2,-2,-1,+1,+2,+2,+1,-1]
    dy = [-1,-1,-2,-2,-1,+1,+2,+2]


    for i in range(8):
        if x+dx[i] <= 0 or y+dy[i] <= 0 or x+dx[i] > 8 or y+dy[i] > 8:
            continue
        result+=1

    return result

def solution2():
    input_data = input()
    row = int(input_data[1])
    column = int(ord(input_data[0])) - int(ord('a')) + 1

    steps = [(-2,-1), (-1,-2), (1,-2), (2,-1), (2,1), (1,2), (-1,2), (-2,1)]

    result = 0
    for step in steps:
        next_row = row + step[0]
        next_column = column + step[1]

        if next_row >= 1 and next_row <= 8 and next_column >= 1 and next_column <= 8:
            result += 1
    
    return result


if __name__ == "__main__":
    print(solution2())