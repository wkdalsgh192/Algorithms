array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

if __name__ == "__main__":
    for i in range(1, len(array)):
        for j in range(i, 0, -1): # 인덱스 i부터 1까지 감소하며 반복
            if array[j] < array[j-1]: # 자신보다 왼쪽에 있는 값 중 큰 값이 있으면
                array[j], array[j-1] = array[j-1], array[j] # 자리를 바꾼다

            else: # 나머지에 대해서는 로직이 필요없으므로 불필요한 순환을 없애기 위해 break 함
                break
    print(array)