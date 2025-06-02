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