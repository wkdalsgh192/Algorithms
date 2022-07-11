def quick_sort(array, s, e):
    if s >= e:
        return

    p = s
    l = p + 1
    r = e

    while l <= r:
        if r < l:
            break
        while l <= r and array[p][1] >= array[l][1]:
            l += 1
        while l <= r and array[p][1] < array[r][1]:
            r -= 1

        if l > r:
            array[p], array[r] = array[r], array[p]
        else:
            array[r], array[l] = array[l], array[r]

    quick_sort(array, s, r - 1)
    quick_sort(array, r, e)

def quick_sort2(array):

    if len(array) <= 1:
        return array

    p = array[0]
    array = array[1:]

    left_array = [x for x in array if x[1] <= p[1]]
    right_array = [x for x in array if x[1] > p[1]]

    return quick_sort2(left_array) + [p] + quick_sort2(right_array)

def answer(array):
    return sorted(array, key=lambda student: student[1])

if __name__ == "__main__":
    n = int(input())
    array = []
    for _ in range(n):
        n, m = input().split()
        array.append((n, int(m)))
    #quick_sort(array,0, len(array)-1)
    #array = quick_sort2(array)
    array = answer(array)
    for i in range(len(array)):
        print(array[i][0], end=' ')

