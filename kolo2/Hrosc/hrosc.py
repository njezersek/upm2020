N = int(input())  # prvo vrstico v stevilo
print(0)   # prvic ugibaj

(i, naprej) = (0, 0)
while "Bingo!" != input():   # ali je bil input Bingo!?
    i += (0 if naprej % 2 == 0 else 1)
    naprej += 1
    print(i)
