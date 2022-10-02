#1
#Change the value 10 in x to 15. Once you're done, x should now be [ [5,2,3], [15,8,9] ]
#Change the last_name of the first student from 'Jordan' to 'Bryant'
#In the sports_directory, change 'Messi' to 'Andres'
#Change the value 20 in z to 30

x = [ [5,2,3], [10,8,9] ] 
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

x[1][0]=15
print (x)
students[0]['last_name']="Bryant"
print (students)

sports_directory['soccer'][0]="Andres"
print (sports_directory)

z[0]["y"]=30
print(z)



#2
students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]
def iterateDictionary(li1):
    for i in range(len(li1)):
            print("First name -",li1[i]['first_name'],"Last Name-" +li1[i]['last_name'])
        
          
        
        
    
iterateDictionary(students) 
# should output: (it's okay if each key-value pair ends up on 2 separate lines;
# bonus to get them to appear exactly as below!)

#2 AND #3
students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]
def iterateDictionary(li1):
    for i in range(len(li1)):
            print("First name -",li1[i]['first_name'],"Last Name-" +li1[i]['last_name'])

iterateDictionary(students) 


def iterateDictionary2(key_name, some_list):
    if key_name=='first_name':
        for i in range(len(some_list)):
            print(some_list[i][key_name])
    elif key_name=='last_name':
        for i in range(len(some_list)):
            print(some_list[i][key_name])
        
            
iterateDictionary2('last_name', students) 
# should output: (it's okay if each key-value pair ends up on 2 separate lines;
# bonus to get them to appear exactly as below!)

#4

dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']}

def printInfo(dojo):
    print(len(dojo['locations']), "locations")
    for location in dojo['locations']:
        print(location)
    print(len(dojo['instructors']), "instructors")
    for instructor in dojo['instructors']:
       print(instructor)
printInfo(dojo)


