array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
    print(array, start, end)
    pivot = start
    left = pivot + 1
    right = end

    while left <= right:
        if start >= end:
            return

        # 유효한 범위 내에서 피벗보다 큰 데이터를 찾는다.
        while left <= end and array[left] <= array[pivot]:
            left += 1
        # 유효한 범위 내에서 피벗보다 작은 데이터를 찾는다.
        while right > start and array[right] >= array[pivot]:
            right -= 1
        # 정렬이 가능한 경우 왼쪽의 작은 값과, 오른쪽의 큰 값을 서로 바꾼다.
        if left <= right:
            array[left], array[right] = array[right], array[left]
        # 더 이상 정렬이 불가능한 경우 피벗을 재배치한다
        else:
            array[right], array[pivot] = array[pivot], array[right]
        quick_sort(array, start, right -1)
        quick_sort(array, right + 1, end)

def quick_sort2(array):
    if len(array) <= 1:
        return array

    pivot = array[0]
    tail = array[1:] #피벗을 제외한 리스트

    left_side = [x for x in tail if x <= pivot] # 피벗보다 작은 값들만 모으고
    right_side = [x for x in tail if x > pivot] # 피벗보다 큰 값들을 모은 뒤

    return quick_sort2(left_side) + [pivot] + quick_sort2(right_side)


if __name__ == "__main__":
    #quick_sort(array, 0, len(array) - 1)
    #print(array)
    print(quick_sort2(array))