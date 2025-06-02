# Example 1: 
text = "Hello, World!"
print(text[0:5])   

# Example 2: 
print(text[:5])    
print(text[7:])    

# Example 3:
print(text[-6:])   
print(text[:-7])   

# Example 4: 
print(text[::2])   
print(text[1::2])  

# Example 5: 
print(text[::-1])   


# Example 1 of a Dictionary
student = {
    "Model": "XR-70",
    "year": 2012,
    "Price": 20000,
    "Color": "Blue"
}

print(student["Model"])  
print(student["Price"])   

# Example 2 of a Dictionary

car = {
    "brand": "Toyota",
    "model": "Corolla",
    "year": 2022,
    "color": "White"
}

print(car["brand"])  
print(car["year"])   


# Use of some Built-In Functions

student = {"name": "Ali", "age": 20, "grade": "A", "city": "Lahore"}

# clear()
student.clear()
print(student)  


prices = {"apple": 150, "banana": 50, "mango": 200, "grapes": 180}

# copy()
duplicate_prices = prices.copy()
print(duplicate_prices)  

# fromkeys()
keys = ["orange", "pineapple", "peach"]
new_prices = dict.fromkeys(keys, 100)
print(new_prices)  

# get()
print(prices.get("mango"))  
print(prices.get("pear", "Not Available"))  

# items()
print(prices.items())  

# keys()
print(prices.keys())  

# pop()
removed_price = prices.pop("banana")
print(removed_price) 
print(prices) 

# popitem()
removed_item = prices.popitem()
print(removed_item)  
print(prices)  

# setdefault()
prices.setdefault("watermelon", 300)
print(prices)  

# update()
new_fruits = {"strawberry": 500, "blueberry": 600}
prices.update(new_fruits)
print(prices)  

# values()
print(prices.values())  










