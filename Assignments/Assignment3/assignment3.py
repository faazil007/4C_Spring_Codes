# # Required Libraries to Import
import matplotlib.pyplot as plt
import numpy as np

# # Required Data for Creation of Chart
# Months = ["January", "February", "March"]
# apples = [120, 145, 160]
# bananas = [90, 110, 95]
# oranges = [150, 130, 170]

# # Totalling the Sum of the Fruits
# total_apples = sum(apples)
# total_bananas = sum(bananas)
# total_oranges = sum(oranges)
# products = ["Apples", "Bananas", "Oranges"]
# totals = [total_apples, total_bananas, total_oranges]

# # Bar chart of total sales per product
# plt.figure(figsize=(10, 10))
# plt.subplot(1 ,2, 1)
# plt.bar(products, totals, color=["red", "yellow", "orange"])
# plt.title("Total Sales Per Product ")
# plt.ylabel("Total Sales")
# plt.xlabel("Products")
# plt.show()

# # Grouped bar chart comparing monthly sales
# x = np.arange(len(Months))  # label locations
# width = 0.25  # bar width

# plt.subplot(1, 2, 2)
# plt.bar(x - width, apples, width, label="Apples", color="red")
# plt.bar(x, bananas, width, label="Bananas", color="yellow")
# plt.bar(x + width, oranges, width, label="Oranges", color="orange")

# plt.xlabel("Month")
# plt.ylabel("Sales")
# plt.title("Monthly Sales Comparison")
# plt.xticks(x, Months)
# plt.legend()

# plt.tight_layout()
# plt.show()




# Line Chart 

# Data
# days = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
# temp = [22, 24, 19, 18, 25, 27, 23]

# # Find hottest and coldest day
# max_temp = max(temp)
# min_temp = min(temp)
# max_day = days[temp.index(max_temp)]
# min_day = days[temp.index(min_temp)]

# # Plotting
# plt.figure(figsize=(10, 5))
# plt.plot(days, temp, marker='o', linestyle='-', color='red', label="Temperature")

# # Annotate hottest day
# plt.annotate(f'Hottest: {max_temp}°C',
#              xy=(max_day, max_temp),
#              xytext=(max_day, max_temp + 1.5),
#              arrowprops=dict(facecolor='Red', shrink=0),
#              color='Red')

# # Annotate coldest day
# plt.annotate(f'Coldest: {min_temp}°C',
#              xy=(min_day, min_temp),
#              xytext=(min_day, min_temp + 1.5),
#              arrowprops=dict(facecolor='Blue', shrink=0),
#              color='blue')

# # Labels and title
# plt.xlabel("Day of Week")
# plt.ylabel("Temperature (°C)")
# plt.title("Weekly Temperature Trend")
# plt.grid(True)
# plt.legend()
# plt.tight_layout()
# plt.show()


# Stacked Bar Chart
# import matplotlib.pyplot as plt

# # Data
# quarters = ["Q1", "Q2", "Q3", "Q4"]
# marketing = [40, 45, 50, 55]
# sales = [60, 70, 65, 80]
# it = [20, 25, 30, 35]

# # Plotting the stacked bar chart
# plt.figure(figsize=(10, 5))

# # First stack: Marketing
# plt.bar(quarters, marketing, label="Marketing", color='skyblue')

# # Second stack: Sales (on top of marketing)
# plt.bar(quarters, sales, bottom=marketing, label="Sales", color='orange')

# # Third stack: IT (on top of marketing + sales)
# # Calculate new bottoms by summing marketing + sales for each quarter
# bottom_sales_marketing = [marketing[i] + sales[i] for i in range(len(quarters))]
# plt.bar(quarters, it, bottom=bottom_sales_marketing, label="IT", color='green')

# # Labels and legend
# plt.xlabel("Quarters")
# plt.ylabel("Revenue")
# plt.title("Quarterly Revenue Contribution by Department")
# plt.legend()
# plt.tight_layout()
# plt.show()

# Histogram
import matplotlib.pyplot as plt

# Sample data: 50 scores (you can add more if needed)
scores = [72, 85, 63, 90, 58, 77, 82, 68, 95, 55,
          70, 88, 65, 78, 92, 60, 73, 84, 91, 87,
          69, 53, 80, 66, 93, 59, 76, 81, 64, 61,
          57, 75, 67, 86, 83, 74, 71, 56, 79, 62,
          94, 89, 52, 50, 49, 48, 45, 40, 35, 30]  # 50 values

# Custom bin edges (0-20, 20-40, ..., 100)
bins = [0, 20, 40, 60, 80, 100]

# Plotting the histogram
plt.figure(figsize=(10, 6))
plt.hist(scores, bins=bins, edgecolor='black', color='skyblue')

# Adding labels and title
plt.xlabel("Score Ranges")
plt.ylabel("Number of Students")
plt.title("Distribution of Exam Scores")
plt.xticks(bins)  # Set x-axis ticks to match bin edges
plt.grid(True, linestyle='--', alpha=0.6)

plt.tight_layout()
plt.show()
