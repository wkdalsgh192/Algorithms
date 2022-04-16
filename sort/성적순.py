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

if __name__ == "__main__":
    n = int(input())
    array = []
    for _ in range(n):
        n, m = input().split()
        array.append((n, int(m)))
    quick_sort(array,0, len(array)-1)
    for i in range(len(array)):
        print(array[i][0], end=' ')

