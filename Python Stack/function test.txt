#1
#the function return 5
def a():
    return 5
print(a())
#2
#the function call 2 time so the output is 5+5=10
def a():
    return 5
print(a()+a())
#3
#the function get the first return 
def a():
    return 5
    return 10
print(a())

#4 the function just print 5 becuse print(10) come after return
def a():
    return 5
    print(10)
print(a())

#5 the function print 5 when call a()  and when print (x) = none
def a():
    print(5)
x = a()
print(x)

#6 the function when call a(1,2) return 3 and a(2,3) return 5 but when say a(1,2) + a(2,3) this mean None + None =None(Type Error)
def a(b,c):
    print(b+c)
print(a(1,2) + a(2,3))

#7 the function return 25 becu "2"+"5"="25"
def a(b,c):
    return str(b)+str(c)
print(a(2,5))




#9
def a(b,c):
    if b<c:  
        return 7
    else:
        return 14
    return 3
print(a(2,3)) #7
print(a(5,3)) #14
print(a(2,3) + a(5,3)) #7+14=21


#10
def a(b,c):
    return b+c #3+5=8
    return 10
print(a(3,5))


#11
b = 500
print(b) #500
def a():
    b = 300
    print(b) #500
print(b)  #300
a() 
print(b) #500

#12
b = 500
print(b) # 500
def a():
    b = 300
    print(b) # 500
    return b
print(b) #300
a() 
#500
print(b)

#13
b = 500
print(b) #500
def a():
    b = 300
    print(b) #500
    return b
print(b) #300
b=a() 
print(b) #300

#14
def a():
    print(1) #1
    b() #3
    print(2) #2
def b():
    print(3)
a()


#15
def a():
    print(1) #1
    x = b() 
    print(x) #3,5
    return 10 #10
def b():
    print(3)
    return 5
y = a() 
print(y)



