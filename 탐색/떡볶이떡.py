
def search(array, M, start, end):
    ans = 0
    while start <= end:
        mid = (start + end) // 2
        mid_array = array[mid:]
        res = sum(mid_array) - array[mid] * len(mid_array)
        print(mid, res)

        if res == M:
            ans = array[mid]
            start = mid + 1
        elif res > M:
            start = mid + 1
        else:
            end = mid - 1
    return ans

if __name__=="__main__":
    n, m = map(int, input().split())
    array = list(map(int, input().split()))

    array.sort()
    print(array)
    print(search(array,m,0,n-1))

