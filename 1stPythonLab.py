# Example 1: Basic slicing (Extracting a substring)
text = "Hello, World!"
print(text[0:5])   # Output: Hello

# Example 2: Omitting start or end index
# print(text[:5])    # Output: Hello (Start from index 0 to 4)
# print(text[7:])    # Output: World! (Start from index 7 to end)

# Example 3: Using negative indices
# print(text[-6:])   # Output: World! (Last 6 characters)
# print(text[:-7])   # Output: Hello, (Excluding last 7 characters)

# Example 4: Using step in slicing
# print(text[::2])   # Output: Hlo ol! (Every 2nd character)
# print(text[1::2])  # Output: el,Wrd (Starting from index 1, every 2nd character)

# Example 5: Reversing a string using slicing
# print(text[::-1])  # Output: !dlroW ,olleH (Reversed string)
