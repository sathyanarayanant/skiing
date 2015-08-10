# Building the project

This project uses gradle as build tool.
To build the project:

1. git clone https://github.com/sathyanarayanant/skiing.git
2. cd skiing
3. ./gradlew build (for linux/mac) or gradlew build (for windows)

# Algorithm (in brief)
    List<Point> sorted = sortByHeightAsc(points);

    PathCache cache = new PathCache();
    List<Point> best = new ArrayList<Point>();
    for (Point point : sorted) {
        List<Point> path = getBestPath(terrain, point, cache);
        cache.put(point, path);

        best = getBetterOf2(path, best);
    }

    return best;


## Finding best path
1. given current point find the left, right, top, bottom points.
2. for each of left, right, top, bottom
3.    get best path from cache and append current point
4. choose the best path out of 4

# Coding structure
Most of the logic is implemented as stateless helper (or utility) functions that can be easily tested.