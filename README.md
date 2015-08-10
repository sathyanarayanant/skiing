# Building the project

This project uses gradle as build tool.
To build the project:

1. git clone https://github.com/sathyanarayanant/skiing.git
2. cd skiing
3. ./gradlew build (for linux/mac) or gradlew build (for windows)

# Algorithm (in brief)
    List<Point> getBestPossiblePath(List<List<Point>> points) {

        Terrain terrain = new Terrain(points);

        List<Point> sorted = sortByHeightAsc(points);

        PathCache cache = new PathCache();
        List<Point> best = new ArrayList<Point>();
        for (Point point : sorted) {
            List<Point> path = getBestPath(terrain, point, cache);
            cache.put(point, path);

            best = getBetterOf2(path, best);
        }

        return best;
    }


## Finding best path
    given current point find the left, right, top, bottom points.
    for each of left, right, top, bottom
        get path from cache and append current point
    choose the best path

# Coding structure
Most of the logic is implemented as stateless helper (or utility) functions that can be easily tested.