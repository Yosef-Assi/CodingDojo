
import statistics
def med (arr1,arr):
    arr2=[]
    for i in arr:
            arr2.append(i)
    for k in arr1:
            arr2.append(k)
    arr2.sort()
    print(arr2)
    for j in arr2:
        if len(arr2)%2==1:
            # print(len(arr2))
            # sum1=sum(arr2)
            # avg=sum1/len(arr2)
            # print(sum1)
            return len(arr2)/2
        else:
            res = statistics.median(arr2)
            return res       

print("The Median is : ",med([1,5,9],[1,2,3,4,5,6]))
        