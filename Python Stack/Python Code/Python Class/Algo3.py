#Leap Year


def is_leap_year(year):
    if year%400==0:
        return 'true'
    elif year%4==0 and year%100!=0:
        return 'true'
    else:
        return 'false'

print(is_leap_year(1800))

#How Many times:


def count_substring(string,sub_string):
    star_index=0 
    count=0
    for i in range(len(string)):
        findstring=string.find(sub_string,star_index)
        if findstring!=-1:
            star_index=findstring+1
            count+=1
    return count


print(count_substring("ABSHIZLMSHIZ","HIZ"))