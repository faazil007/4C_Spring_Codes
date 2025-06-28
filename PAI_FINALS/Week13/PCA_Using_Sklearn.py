
import numpy as np
from sklearn.preprocessing import StandardScaler

# Sample 3D data
X = np.random.rand(4, 3)

#Step by step without SKlearn PCA (3D → 2D)

# Step 1 - Apply standard scaling
scaler = StandardScaler()
Xstd = scaler.fit_transform(X)

# Step 2 - Find Covariance Matrix
covariance_matrix = np.cov([Xstd[:,0],Xstd[:,1],Xstd[:,2]])
print('Covariance Matrix:\n', covariance_matrix)

# Step 3 - Finding EV and EVs
eigen_values,eigen_vectors = np.linalg.eig(covariance_matrix)

# Sort eigenvalues in descending order
idx = eigen_values.argsort()[::-1]
eigen_values = eigen_values[idx]
eigen_vectors = eigen_vectors[:, idx]

print("Eigenvalues:\n", eigen_values)
print("Eigenvectors:\n", eigen_vectors)

# Step 4: Project onto top 2 PCs
k = 2
W = eigen_vectors[:, :k]
print(W.shape)
print(X.shape)
X_pca = np.dot(X,W)

print("Reduced Data (2D):\n", X_pca)




from sklearn.decomposition import PCA

# Sample 3D data
X = np.random.rand(4, 3)

# Using SKlearn PCA (3D → 2D)
pca = PCA(n_components=2)
X_2D = pca.fit_transform(X)

print(X_2D)
print("Explained Variance Ratio:", pca.explained_variance_ratio_)
