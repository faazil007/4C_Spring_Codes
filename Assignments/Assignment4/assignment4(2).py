# Examples of K-Fold Cross Validation
# Example 1
from sklearn.model_selection import KFold 
import numpy as np 
# Create some example data 
X = np.array([[1, 2], [3, 4], [5, 6], [7, 8]]) 
y = np.array([1, 2, 3, 4]) 
# Initialize KFold with number of splits 
kf = KFold(n_splits=2) 
# Perform cross-validation 
for train_index, test_index in kf.split(X): 
    print("Train Index:", train_index, ", Test Index:", test_index) 
    X_train, X_test = X[train_index], X[test_index] 
    y_train, y_test = y[train_index], y[test_index] 
    print("X_train:", X_train, ", y_train:", y_train) 
    print("X_test:", X_test, ", y_test:", y_test) 


# Example 2
# Create dictionary of PAI result, based on PF and Attendance
import pandas as pd  # Import pandas for data manipulation

# Define a dictionary with PF (performance factor), Att (attendance), and Result (pass/fail)
dic = {
    'PF':    [90, 50, 40, 60, 30, 70, 30, 20, 80],  # Performance scores
    'Att':   [60, 50, 70, 50, 30, 40, 60, 35, 20],  # Attendance scores
    'Result':[1, 1, 1, 1, 0, 0, 0, 0, 0]            # Target variable (1 = pass, 0 = fail)
}

# Convert the dictionary into a pandas DataFrame
dataset = pd.DataFrame(dic)  # Create a structured table from the dictionary

# Separate the features (PF and Att) from the target column (Result)
X = dataset.iloc[:, :2]        # Select all rows and first two columns (PF and Att)
y = dataset['Result']          # Select the 'Result' column as the target

# Import KFold from sklearn for splitting the data into K folds
from sklearn.model_selection import KFold  # Import here to keep everything visible together

# Initialize KFold cross-validation with 3 splits
kf = KFold(n_splits=3)  # Split data into 3 parts/folds

foldNumber = 1  # Variable to keep track of the fold number

# Perform K-Fold cross-validation
for train_index, test_index in kf.split(X):  # For each split, get train and test indices
    # Split the data into training and testing sets using the indices
    X_train, X_test = X.iloc[train_index], X.iloc[test_index]  # Training and testing features
    y_train, y_test = y.iloc[train_index], y.iloc[test_index]  # Training and testing labels

    # Print current fold info
    print("====================")
    print("Fold:", foldNumber)  # Display current fold number
    print("====================")

    # Show training data
    print("X_Train:\n", X_train)  # Display training features
    print("Y_Train:\n", y_train)  # Display training labels
    print()

    # Show testing data
    print("X_Test\n", X_test)     # Display testing features
    print("Y_Test\n", y_test)     # Display testing labels
    print()

    # Move to next fold
    foldNumber += 1
