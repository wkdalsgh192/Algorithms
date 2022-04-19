def attempt():
    n, k = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    A = sorted(A, key=lambda elem: elem)
    B = sorted(B, key=lambda elem: elem, reverse=True)

    sum = 0
    for i in range(n):
        if k > 0 and A[i] < B[i]:
            sum += B[i]
            k -= 1
        else:
            sum += A[i]

    print(sum)

def solution():
    n, k = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    a.sort()
    b.sort(reverse=True)

    for i in range(k):
        if a[i] < b[i]:
            a[i], b[i] = b[i], a[i]
        else:
            break

    print(sum(a))

if __name__ == "__main__":
    #attempt()
    solution()

