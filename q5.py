num = int(input("Enter a number: "))

original = num
total = 0

while num > 0:
    digit = num % 10
    total = total + digit ** 3
    num = num // 10

if total == original:
    print("Armstrong number")
else:
    print("Not an Armstrong number")