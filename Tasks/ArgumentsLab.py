# Example Questions
def my_function(x,y):
    return "MY ID : ", 5*x

st,result= my_function(6,5)
print(type(result))



# Example 2
def my_function(*,x,y):
    return "MY ID : ", 5*x

st,result= my_function(x=6 , y=5)   # Keyword only technique


#Example 3

def my_function(x,y,/):
    return "MY ID : ", 5*x

st,result= my_function(5,9)
print(type(st))                     # Position Only Technique

# Example 4

def my_function(x,/,*,y):
    return "MY ID : ", 5*x

st,result= my_function(6,y=5)   

# Example 5

def print_name():
    for i in range(10):
        print("Ali")

print_name()


# Example 6
def print_name(name):
    for i in range(10):
        print(name)

print_name("Ahmad")
print_name("Zain")        

# Example 7

def print_name(*name):
    print(type(name),name[0])

print_name("Ali" ,  "Zain" , "Ahmad")    

# Example 8
def print_name(**name):
    print(name["n3"])

print_name(n1="Ali" , n3 = "Shehzaad" , n2="Bilal")

# Example 9
def new_function(country =" Pakistan"):
    print(" Belong to " + country)

new_function(" Germany")
new_function()
new_function(" Scotland")    





    


