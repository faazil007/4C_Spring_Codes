# Variations of K-Fold Cross Validations
# Example 1
from sklearn.datasets import load_boston 
from sklearn.model_selection import cross_val_score 
from sklearn.linear_model import LinearRegression 
 
# Load the Boston Housing dataset 
boston = load_boston() 
X = boston.data 
y = boston.target 
 
# Initialize Linear Regression model 
model = LinearRegression() 
 
# Perform k-fold cross-validation (let's use k=5 for this example) 
k = 5 
scores = cross_val_score(model, X, y, cv=k, 
scoring='neg_mean_squared_error') 
 
# Convert the negative MSE scores to positive 
mse_scores = -scores 
 
# Print the MSE scores for each fold 
print("MSE Scores for each fold:", mse_scores) 
 
# Calculate the mean and standard deviation of the MSE scores 
mean_mse = mse_scores.mean() 
std_mse = mse_scores.std() 
 
print("\nMean MSE:", mean_mse) 
print("Standard Deviation of MSE:", std_mse) 



# Example 2
from sklearn.datasets import load_breast_cancer 
from sklearn.model_selection import cross_val_score 
from sklearn.linear_model import LogisticRegression 
 
# Load the Breast Cancer Wisconsin dataset 
breast_cancer = load_breast_cancer() 
X = breast_cancer.data 
y = breast_cancer.target 
 
# Initialize Logistic Regression model 
model = LogisticRegression() 
 
# Perform k-fold cross-validation (let's use k=5 for this example) 
k = 5 
scores = cross_val_score(model, X, y, cv=k, scoring='accuracy') 
 
# Print the accuracy scores for each fold 
print("Accuracy Scores for each fold:", scores) 
 
# Calculate the mean and standard deviation of the accuracy scores 
mean_accuracy = scores.mean() 
std_accuracy = scores.std() 
 
print("\nMean Accuracy:", mean_accuracy) 
print("Standard Deviation of Accuracy:", std_accuracy) 



# Example 3
from sklearn.datasets import load_iris 
from sklearn.model_selection import cross_val_score 
from sklearn.linear_model import LogisticRegression 
 
# Load the Iris dataset 
iris = load_iris() 
X = iris.data 
y = iris.target 
 
# Initialize Logistic Regression model 
model = LogisticRegression(max_iter=1000)  # Increase max_iter to ensure convergence 
 
# Perform k-fold cross-validation (let's use k=5 for this example) 
k = 5 
scores = cross_val_score(model, X, y, cv=k, scoring='accuracy') 
 
# Print the accuracy scores for each fold 
print("Accuracy Scores for each fold:", scores) 
 
# Calculate the mean and standard deviation of the accuracy scores 
mean_accuracy = scores.mean() 
std_accuracy = scores.std() 
 
print("\nMean Accuracy:", mean_accuracy) 
print("Standard Deviation of Accuracy:", std_accuracy) 


