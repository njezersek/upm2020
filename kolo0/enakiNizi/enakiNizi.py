n = int(input())

for i in range(n):
    a = input()
    b = input()

    A = "".join(a.split().sort())
    B = "".join(b.split().sort())

    if A == B :
        print("enaka")
    else:
        print("razlicna")
    