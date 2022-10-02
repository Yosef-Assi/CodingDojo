#Example: countdown(5) should return [5,4,3,2,1,0]
#1
def count_down(x):
    count=x;
    while x>=0:
        print(x)
        x-=1
        
count_down(5)


#2
#Example: print_and_return([1,2]) should print 1 and return 2

def print_and_return(list1):
    print(list1[0])
    return list1[1]
    


print(print_and_return([1,2]))

#3
#first_plus_length([1,2,3,4,5]) should return 6 (first value: 1 + length: 5)


def first_plus_length(list1):
    sum=list1[0]+len(list1)
    return sum

print(first_plus_length([1,2,3,4,5]))  


#4 
#Example: values_greater_than_second([5,2,3,2,1,4]) should print 3 and return [5,3,4]

def values_greater_than_second(list1):
    list2=[]
    for x in list1:
        if len(list1)==1:
            return 'false'
            
        if x>list1[1]:
            list2.append(x)
    return list2
    
    
print(values_greater_than_second([5,2,3,2,1,4]));
            

#5

#Example: length_and_value(4,7) should return [7,7,7,7]
#Example: length_and_value(6,2) should return [2,2,2,2,2,2]

def length_and_value(length,val):
    list1=[]
    count=length
    while count>0:
        list1.append(val)
        count-=1
    return list1
    
print(length_and_value(4,7))  
print(length_and_value(6,2))        
        
             