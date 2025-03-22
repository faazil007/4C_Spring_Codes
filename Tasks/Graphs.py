import matplotlib.pyplot as plt

# Creating a Bar Graph
categories = ['A' , 'B' , 'C' , 'D' , 'E']
values = [23,45,56,78,32]
# plt.bar(categories,values)
# plt.xlabel('Categories')
# plt.ylabel('Values')
# plt.title('Simple Bar Graph')
# plt.show()

# Creating a Horizontal Bar graph
plt.barh(categories,values)
plt.xlabel('Categories')
plt.ylabel('Values')
plt.title('Simple Bar Graph')
plt.show()

# Creating a line graph
x=[1,2,3,4,5]
y=[10,20,30,40,50]
plt.plot(x,y)
plt.xlabel('X-Axis')
plt.ylabel('Y-Axis')
plt.title('Simple Line Graph')
plt.show()

# Creating a Scatter Graph
plt.scatter(categories,values)
plt.xlabel('Categories')
plt.ylabel('Values')
plt.title('Simple Bar Graph')
plt.show()

# Creating a Pie Chart
labels=['A' , 'B' , 'C' , 'D']
sizes = [15,30,45,10]
plt.pie(sizes , labels = labels , autopct='%1.1f%%')
