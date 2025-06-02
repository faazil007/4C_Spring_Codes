# Stratified K-Fold Cross Validation
# Example 1 
from sklearn.model_selection import StratifiedKFold  # Import StratifiedKFold for cross-validation preserving the distribution of the target variable
import numpy as np  # Import NumPy for array manipulation

# Create some example data
X = np.array([[1, 2], [3, 4], [5, 6], [7, 8]])  # Features: 4 samples, each with 2 features
y = np.array([0, 0, 1, 1])  # Labels for binary classification (0 = class 1, 1 = class 2)

# Initialize StratifiedKFold with 2 splits
skf = StratifiedKFold(n_splits=2)  # This ensures each fold has a balanced representation of both classes

# Perform cross-validation
for train_index, test_index in skf.split(X, y):  # Split data while preserving class distribution in each fold
    print("Train Index:", train_index, ", Test Index:", test_index)  # Print the indices of the training and testing data

    # Use the indices to split data into training and testing sets
    X_train, X_test = X[train_index], X[test_index]  # Split the features (X)
    y_train, y_test = y[train_index], y[test_index]  # Split the target labels (y)

    # Display training and testing data
    print("X_train:", X_train, ", y_train:", y_train)  # Show the training features and corresponding labels
    print("X_test:", X_test, ", y_test:", y_test)  # Show the testing features and corresponding labels

# Example 2
from sklearn.model_selection import  StratifiedKFold 
import pandas as pd 
 
#Create dictionary of PAI result, based on PF and Attendance 
dic = {'PF':    [90,50,40,60,30,70,30,20,80], 
       'Att':   [60,50,70,50,30,40,60,35,20], 
       'Result':[1,1,1,1,0,0,0,0,0] 
      } 
 
#Convert to Dataframe 
dataset = pd.DataFrame(dic) 
 
#Separate Features and Target columns 
X = dataset.iloc[:,:2] 
y = dataset['Result'] 
 
# Initialize StratifiedKFold with number of splits 
skf = StratifiedKFold(n_splits=3) 
 
foldNumber = 1 
# Perform cross-validation 
for train_index,test_index in skf.split(X,y): 
    X_train,X_test = X.iloc[train_index], X.iloc[test_index] 
    y_train,y_test = y.iloc[train_index], y.iloc[test_index] 
    print("====================") 
    print("Fold:",foldNumber) 
    print("====================") 
    print("X_Train:\n",X_train) 
    print("Y_Train:\n",y_train) 
    print() 
    print("X_Test\n",X_test) 
    print("Y_Test\n",y_test) 
    print() 
    foldNumber += 1