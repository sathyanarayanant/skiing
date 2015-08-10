# Building the project

This project uses gradle as build tool.
To build the project:

1. git clone https://github.com/sathyanarayanant/skiing.git
2. cd skiing
3. ./gradlew build (for linux/mac) or gradlew build (for windows)

# Algorithm (in brief)
1. Sort points by height (in ascending order)
2. for each point in sorted list
      best_path = find_best_path # best path is the point itself for the point with least height
      cache.put(point, best_path)

## Finding best path
1. given current point find the left, right, top, bottom points.
2. for each of left, right, top, bottom
3.    get best path from cache and append current point
4. choose the best path out of 4

# Coding structure
Most of the logic is implemented as stateless helper (or utility) functions that can be easily tested.