num1 = int(input("Enter first number: "))
num2 = int(input("Enter second number: "))

while num2 != 0:
    remainder = num1 % num2
    num1 = num2
    num2 = remainder

print("GCD =", num1)