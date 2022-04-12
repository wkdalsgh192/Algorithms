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


if __name__ == "__main__":
    selection_sort()
