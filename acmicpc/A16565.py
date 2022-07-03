def reader():
    a,r=0,range
    for i in r((n:=int(input()))//4):
     b,k=1,i+1
     for j in r(k):b*=13-j;b//=j+1
     for j in r(n-4*k):b*=52-4*k-j;b//=j+1
     a+=b*(1-(i&1)*2)
    print(a%10007)


if __name__ == '__main__':
    reader()
