
# Question NO#01
#1
list_numbers = [34, 12, 56, 78, 23, 89, 45, 67, 90, 11]
print("List :: ", list_numbers)

#2
list_numbers.append(50)   # Append Function adds a new element to the end of the list
print("A new number is added to the list at the end ::", list_numbers)

#3
del list_numbers[0]
print("1st Element removed from the list ::", list_numbers)   # del function removes the value on the given index

#4
list_numbers.sort()
print("Whole list is sorted ::", list_numbers) # sort function by default sorts the list into ascending order

#5
list_numbers.reverse()
print("Reversed list ::", list_numbers)  # reverse function reverses the whole list

#Question No#02
# A dictionary created with 5 Key-Value pairs
data = {
    "Name::": "Muhammad Fazil",
    "Age::": 20,
    "Residence": "Islamabad",
    "Profession": "Student",
    "Expense": 5000
}
print(f"Orginal Dictionary {data}")

# Adding a new Value
data["Country"] = "Pakistan"
print(f" Updated Dictionary after Adding a Value{data}")

# Updating the value 
data["Age"] = 26
print(f" Updated Dictionary after Updating a Value{data}")

# Removing a key-value pair
del data["Expense"]
print(f" Updated Dictionary after Removing a Key{data}")

# Printing all keys and values in the dictionary
print(" Whole Dictionary Contents:")
for key, value in data.items():
    print(f"{key}: {value}")


Question No#03
A list of dictionaries is created 
people = [
    {"Name::": "Saim Iftikhar", "Age::": 20, "Residence::": "Kallar Sayedaan"},
    {"Name::": "Abdullah Ibrahim", "Age::": 22, "Residence::": "I-10 Islamabad"},
    {"Name::": "Zohaib Asghar", "Age::": 20, "Residence::": "ACHS"}
]
print(f"Whole list of Dictionaries{people}")

# New person added to the Dictionary
new_person = {"Name::": "Hadain", "Age::": 20, "Residence::": "Alipur"}
people.append(new_person)
print(f"List of dictionaries after adding a new Person {people}")


# A person removed from the Dictionary
name_to_remove = "Abdullah Ibrahim"
people = [person for person in people if person["Name::"] != name_to_remove]
print(f"List of dictionaries after removing a person {people}")

# Printing the details of all people in the list
print("List of people:")
for person in people:
    print(f"Name: {person['Name::']}, Age: {person['Age::']}, City: {person['Residence::']}")


Question No#04

def string_operations():
    # Take input from user
    user_string = input("Enter a String of your own:: ")
    
    # Converted to uppercase
    uppercase_string = user_string.upper()
    print(f" Uppercased String is :: {uppercase_string}")
    
    # Reversed the string
    reversed_string = user_string[::-1]
    print(f" Reversed String is :: {reversed_string}")
    
    # Check if palindrome
    is_palindrome = user_string.lower() == reversed_string.lower()
    print( "It is Palindrome" if is_palindrome else "It is not a palindrome")
    
    # Count number of vowels
    vowels = "aeiouAEIOU"
    vowel_count = sum(1 for char in user_string if char in vowels)
    print("Number of Vowels:", vowel_count)

# Run the function
string_operations()

#Question No#05
def word_list_operations():
    # Take input words from user
    words = input("Enter words separated by spaces: ").split()
    
    # Create list of dictionaries with word length
    word_list = [{"word": word, "length": len(word)} for word in words]
    
    # Sort the list based on word length
    word_list.sort(key=lambda x: x["length"])
    
    # Find the word with maximum length
    max_length_word = max(word_list, key=lambda x: x["length"])
    
    # Print results
    print("Sorted List of Words with Lengths:", word_list)
    print("Word with Maximum Length:", max_length_word["word"])

# Run the function
word_list_operations()
