                         # Train Test Split Examples

# # Example 1
# # Importing the LinearRegression model from sklearn's linear_model module
# from sklearn.linear_model import LinearRegression  

# # Importing numpy library for working with arrays and numerical data
# import numpy as np  

# # Importing the function to split dataset into training and testing sets
# from sklearn.model_selection import train_test_split  

# # Defining the input features (X) as a 2D numpy array
# X = np.array([[1], [2], [3], [4], [5]])  

# # Defining the target/output values (y) as a 1D numpy array
# y = np.array([2, 4, 6, 8, 10])  

# # Splitting the dataset into training (80%) and testing (20%) subsets
# # random_state ensures the split is the same every time (for consistency)
# X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)  

# # Creating an instance of the LinearRegression model
# model = LinearRegression()  

# # Training the model using the training data
# model.fit(X_train, y_train)  

# # Making predictions on the test data using the trained model
# test_predictions = model.predict(X_test)  

# # Printing the predicted values for the test set
# print("Test Predictions:", test_predictions)  

# # Printing the actual values from the test set
# print("Actual Values:", y_test)

# # Example 2
# # Importing the Iris dataset from sklearn's datasets module
# from sklearn.datasets import load_iris  
# # Importing the function to split data into training and testing sets
# from sklearn.model_selection import train_test_split  
# # Importing the LogisticRegression model for classification
# from sklearn.linear_model import LogisticRegression  
# # Importing accuracy_score to evaluate the model's performance
# from sklearn.metrics import accuracy_score  
# # Load the Iris dataset (150 samples of 3 types of flowers)
# iris = load_iris()  
# # Extracting feature data (sepal length, sepal width, petal length, petal width)
# X = iris.data  
# # Extracting target labels (0 = Setosa, 1 = Versicolor, 2 = Virginica)
# y = iris.target  
# # Splitting data: 80% for training, 20% for testing
# # random_state=42 makes sure the split is always the same (for reproducibility)
# X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)  
# # Creating a Logistic Regression model instance
# model = LogisticRegression()  
# # Training (fitting) the model using the training data
# model.fit(X_train, y_train)  
# # Making predictions using the test data
# y_pred = model.predict(X_test)  
# # Calculating accuracy of predictions compared to actual test labels
# accuracy = accuracy_score(y_test, y_pred)  
# # Printing the accuracy result
# print("Accuracy:", accuracy)  
# Example 3
from sklearn.datasets import load_boston 
from sklearn.model_selection import train_test_split 
from sklearn.linear_model import LinearRegression 
from sklearn.metrics import mean_squared_error, r2_score 
 
# Load the Boston Housing dataset consists of 506 samples of houses 
boston = load_boston() 
X = boston.data 
y = boston.target 
 
# Split the data into training and testing sets (80% train, 20% test) 
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, 
random_state=42) 
 
# Initialize Linear Regression model 
model = LinearRegression() 
 
# Train the model on the training data 
model.fit(X_train, y_train) 
 
# Predict the target values for the test set 
y_pred = model.predict(X_test) 
 
# Evaluate the model's performance 
mse = mean_squared_error(y_test, y_pred) 
r2 = r2_score(y_test, y_pred) 
 
print("Mean Squared Error:", mse) 
print("R-squared:", r2) 

# # Example 4
import numpy as np 
from sklearn.model_selection import train_test_split 
from sklearn.linear_model import LinearRegression 
from sklearn.metrics import mean_squared_error, r2_score 
 
# Generate some sample data 
np.random.seed(42) 
X = np.random.rand(100, 1) * 10  # Generate 100 random values between 0 and 
10 
y = 3 * X + 2 + np.random.randn(100, 1)  # Linear relationship with some random noise 
 
# Split the data into training and testing sets (80% train, 20% test) 
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, 
random_state=42) 
 
# Initialize Linear Regression model 
model = LinearRegression() 
 
# Train the model on the training data 
model.fit(X_train, y_train) 
 
# Predict the target values for the test set 
y_pred = model.predict(X_test) 
 
# Evaluate the model's performance 
mse = mean_squared_error(y_test, y_pred) 
r2 = r2_score(y_test, y_pred) 
 
print("Mean Squared Error:", mse) 
print("R-squared:", r2) 



