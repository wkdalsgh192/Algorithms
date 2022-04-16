def selection_sort():
    n = int(input())
    array = []
    for _ in range(n):
        num = int(input())
        array.append(num)

    for i in range(n):
        min_index = i
        for j in range(i + 1, n):
            if array[min_index] < array[j]:
                array[min_index], array[j] = array[j], array[min_index]

    print(array)

def insertion_sort():
    n = int(input())
    array = []
    for _ in range(n):
        array.append(int(input()))

    for i in range(1, len(array)):
        for j in range(i, 0, -1):
            if array[j] > array[j-1]: # 뒤가 더 크면 앞으로 보낸다
                array[j], array[j-1] = array[j-1], array[j]
            else:
                break

    print(array)


if __name__ == "__main__":
    #selection_sort()
    insertion_sort()
