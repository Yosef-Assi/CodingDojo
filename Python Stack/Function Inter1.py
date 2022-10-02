
import random

def randInt(num1='' ,num2='' ):
    if num1=="" and num2=='':
        x=random.randint(0,100)
        
    elif num1 != '' and num2 !='':
        x=random.randint(int(num1),int(num2))
        
    elif num2 != '':
        x=random.randint(0,int(num2))
        
    elif num1 !='':
        x=random.randint(int(num1),100)
        
    return x
print(randInt())
print(randInt(num1='2',num2='80'))
print(randInt(num1='2'))
print(randInt(num2=80))
