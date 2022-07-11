def search(array, target, start, end):
    res = 0
    while start <= end:
        total = 0
        mid = (start + end) // 2

        for x in array:
            if x > mid:
                total += x - mid
        
        if total > target:
            start = mid + 1
        elif total < target:
            end = mid - 1
        else:
            res = mid
            start = mid + 1
    return res

if __name__=="__main__":
    n, m = map(int, input().split())
    array = list(map(int, input().split()))

    print(search(array,m,0,max(array)))



