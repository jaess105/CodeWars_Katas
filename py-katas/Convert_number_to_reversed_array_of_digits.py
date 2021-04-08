def digitize(n):
    x = []
    while(n!=0):
        x.append(n%10)
        n //=10
    return x