array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

if __name__ == "__main__":
    for i in range(len(array)):
        min_index = i # 다음으로 정렬할 인덱스
        for j in range(i+1, len(array)): # 정렬되지 않은 범위에서
            if array[min_index] > array[j]:
                min_index = j # 가장 작은 값의 인덱스 찾기

        array[i], array[min_index] = array[min_index], array[i] # 스와프

    print(array)


